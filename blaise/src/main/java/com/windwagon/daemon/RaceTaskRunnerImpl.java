package com.windwagon.daemon;

import com.windwagon.broceliande.race.entities.*;
import com.windwagon.broceliande.race.repositories.*;
import com.windwagon.logres.mail.*;
import com.windwagon.logres.triggers.*;

import org.apache.commons.lang.exception.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

import javax.annotation.*;

public class RaceTaskRunnerImpl implements RaceTaskRunner {

	private final static Logger logger = LoggerFactory.getLogger(RaceTaskRunnerImpl.class);

	@Autowired
	private Maestro maestro;

	@Autowired
	private RaceRepository raceRepository;

	@Autowired
	private TemplateMailSenderFactory templateMailSenderFactory;

	private Long raceId;

	private Date raceStart;

	private RaceTask raceTask;

	private OffsetTrigger offsetTrigger;

	private TemplateMailSender successMailSender;

	private TemplateMailSender errorMailSender;

	private boolean enabled = true;

	public RaceTaskRunnerImpl(Long raceId, RaceTask raceTask, OffsetTrigger offsetTrigger) {
		this.raceId = raceId;
		this.raceTask = raceTask;
		this.offsetTrigger = offsetTrigger;
	}

	@PostConstruct
	@Transactional
	public void init() {

		successMailSender = templateMailSenderFactory.getTemplateMailSender(raceTask.getEnvKey() + Maestro.ENV_MAIL_SUCCESS_SUFFIX);
		errorMailSender = templateMailSenderFactory.getTemplateMailSender(raceTask.getEnvKey() + Maestro.ENV_MAIL_ERROR_SUFFIX);

		raceStart = raceRepository.findOne(raceId).getStart();

	}

	@Override
	@Transactional
	public void run() {

		Race race = raceRepository.findOne(raceId);

		RaceStatus expectedStatus = raceTask.getRaceStatus();

		RaceStatus raceStatus = race.getStatus();

		// run the task if enabled and the status is OK
		if (enabled && raceStatus == expectedStatus) {

			Map<String, Object> context = new HashMap<>();
			context.put(Maestro.CXT_RACE, race);

			try {

				raceTask.run(context, race);

				successMailSender.send(context);

			} catch (Throwable ex) {

				logger.error("Error during executing task {} on {}", raceTask.getName(), race, ex);

				context.put(Maestro.CXT_STACKTRACE, ExceptionUtils.getStackTrace(ex));
				errorMailSender.send(context);

			}

			raceStatus = race.getStatus();

		}

		Date nextExecution = offsetTrigger.nextExecutionTime(race.getStart());

		// disabled the trigger if the status is not OK anymore or if no more
		// execution are scheduled
		enabled = raceStatus == expectedStatus && nextExecution != null;

		// re-schedule tasks if the status has changed
		if (raceStatus != expectedStatus) maestro.scheduleRaceTask(race);

	}

	@Override
	public Date nextExecutionTime(TriggerContext triggerContext) {
		return enabled ? offsetTrigger.nextExecutionTime(raceStart) : null;
	}

}
