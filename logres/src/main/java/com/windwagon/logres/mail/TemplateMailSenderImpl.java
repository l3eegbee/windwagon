package com.windwagon.logres.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class TemplateMailSenderImpl implements TemplateMailSender {

	private final static Logger logger = LoggerFactory.getLogger(TemplateMailSenderImpl.class);

	private static String CXT_FROM = "mailFrom";

	private static String CXT_TO = "mailTo";

	private static String CXT_SUBJECT = "mailSubject";

	@Autowired
	private TemplateMailSenderFactory templateMailSenderFactory;

	@Autowired
	private MailSender mailSender;

	private String confId;

	private MailConfig mailConfig;

	public TemplateMailSenderImpl(String confId) {
		this.confId = confId;
	}

	@PostConstruct
	public void init() {

		// get config
		mailConfig = templateMailSenderFactory.getMailConfig(confId);

	}

	private String merge(Template template, VelocityContext context) {

		try (StringWriter writer = new StringWriter()) {
			template.merge(context, writer);
			return writer.toString();
		} catch (IOException ex) {
			throw new RuntimeException();
		}

	}

	@Override
	public void send(Map<String, Object> context) {

		if (!mailConfig.enabled()) return;

		VelocityContext velocityContext = new VelocityContext(templateMailSenderFactory.getDefaultContext());
		for (Map.Entry<String, Object> entry : context.entrySet())
			velocityContext.put(entry.getKey(), entry.getValue());

		String mergedFrom = merge(mailConfig.from(), velocityContext);
		velocityContext.put(CXT_FROM, mergedFrom);

		String mergedTo = merge(mailConfig.to(), velocityContext);
		velocityContext.put(CXT_TO, mergedTo);

		String mergedSubject = merge(mailConfig.subject(), velocityContext);
		velocityContext.put(CXT_SUBJECT, mergedSubject);

		String mergedContent = merge(mailConfig.content(), velocityContext);

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setFrom(mergedFrom);
		mail.setTo(mergedTo);
		mail.setSubject(mergedSubject);
		mail.setText(mergedContent);

		try {
			mailSender.send(mail);
		} catch (MailException ex) {
			logger.error("Can't send mail to [" + mergedTo + "].", ex);
		}

	}

}
