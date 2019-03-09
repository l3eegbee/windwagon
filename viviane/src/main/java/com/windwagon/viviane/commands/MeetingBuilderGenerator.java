package com.windwagon.viviane.commands;

import android.annotation.*;

import com.windwagon.broceliande.race.entities.*;
import com.windwagon.broceliande.race.repositories.MeetingRepository;

import org.apache.velocity.*;
import org.apache.velocity.app.*;
import org.apache.velocity.runtime.*;
import org.apache.velocity.runtime.resource.loader.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;

@Component
@SuppressLint("NewApi")
public class MeetingBuilderGenerator {

	@Value("${builders.builders.package}")
	private String BUILDERS_PACKAGE;

	@Value("${builders.entities.package}")
	private String ENTITIES_PACKAGE;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private MeetingRepository meetingRepository;

	private VelocityEngine velocityEngine;

	private final static DateFormat BUILDER_CLASSNAME_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

	private final static String DATE_FORMAT_PATTERN = "dd/MM/yyyy HH:mm:ss Z";

	private final static DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN);

	public MeetingBuilderGenerator() {

		velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.setProperty("classpath.resource.loader.cache", false);
		velocityEngine.setProperty("velocimacro.library.autoreload", true);
		velocityEngine.init();

	}

	public static class Sorter {

		public <T extends Comparable<T>> List<T> sortSet(Set<T> set) {

			List<T> list = new Vector<T>(set);
			Collections.sort(list);
			return list;

		}

	}

	public static class NullObject {

		public boolean isNull(Object object) {
			return object == null;
		}

		public boolean isNotNull(Object object) {
			return object != null;
		}

	}

	private String getMeetingBuilderFileName(Meeting meeting) {

		return new StringBuilder("Meeting_").append(BUILDER_CLASSNAME_DATE_FORMAT.format(meeting.getDate())).append("_M").append(meeting.getNumber()).toString();

	}

	@Transactional
	public String transactionalMeetingBuilder(String directory) throws IOException {

		Path rootDirectory = Paths.get(directory).toAbsolutePath();
		Files.createDirectories(rootDirectory);

		Template template = velocityEngine.getTemplate("templates/meetingBuilder.template.java");

		for (Meeting meeting : meetingRepository.findAll()) {

			String fileName = getMeetingBuilderFileName(meeting);
			File meetingFile = Paths.get(rootDirectory.toString(), fileName + ".java").toFile();

			VelocityContext context = new VelocityContext();
			context.put("buildersPackage", BUILDERS_PACKAGE);
			context.put("entitiesPackage", ENTITIES_PACKAGE);
			context.put("className", fileName);
			context.put("meeting", meeting);
			context.put("dateFormatPattern", DATE_FORMAT_PATTERN);
			context.put("dateFormat", DATE_FORMAT);
			context.put("sorter", new Sorter());
			context.put("null", new NullObject());

			try (FileWriter writer = new FileWriter(meetingFile)) {
				template.merge(context, writer);
			}

		}

		return "OK";

	}

}
