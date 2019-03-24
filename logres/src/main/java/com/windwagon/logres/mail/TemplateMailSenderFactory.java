package com.windwagon.logres.mail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.generic.AlternatorTool;
import org.apache.velocity.tools.generic.ClassTool;
import org.apache.velocity.tools.generic.ComparisonDateTool;
import org.apache.velocity.tools.generic.ConversionTool;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.DisplayTool;
import org.apache.velocity.tools.generic.EscapeTool;
import org.apache.velocity.tools.generic.FieldTool;
import org.apache.velocity.tools.generic.MathTool;
import org.apache.velocity.tools.generic.NumberTool;
import org.apache.velocity.tools.generic.ResourceTool;
import org.apache.velocity.tools.generic.SortTool;
import org.apache.velocity.tools.generic.XmlTool;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TemplateMailSenderFactory {

	private static String CXT_HOSTNAME = "hostname";

	private static String CXT_DEFAULT_HOSTNAME = "localhost";

	private VelocityContext defaultContext;

	private void addVelocityTool(VelocityContext context, Class<?> clazz) {

		DefaultKey anno = clazz.getAnnotation(DefaultKey.class);
		if (anno == null) throw new RuntimeException("No default key for Velocity tool " + clazz);

		Object tool = null;

		try {
			Constructor<?> constructor = clazz.getConstructor();
			tool = constructor.newInstance();
		} catch (NoSuchMethodException ex) {
			throw new RuntimeException("No default constructor for Velocity tool " + clazz);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
			throw new RuntimeException("Exception during instanciation of Velocity tool " + clazz, ex);
		}

		context.put(anno.value(), tool);

	}

	@PostConstruct
	public void init() {

		// create default context

		defaultContext = new VelocityContext();

		// add hostname
		try {
			defaultContext.put(CXT_HOSTNAME, InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException ex) {
			defaultContext.put(CXT_HOSTNAME, CXT_DEFAULT_HOSTNAME);
		}

		// add tools

		addVelocityTool(defaultContext, AlternatorTool.class);
		addVelocityTool(defaultContext, ClassTool.class);
		addVelocityTool(defaultContext, ComparisonDateTool.class);
		addVelocityTool(defaultContext, ConversionTool.class);
		addVelocityTool(defaultContext, DateTool.class);
		addVelocityTool(defaultContext, DisplayTool.class);
		addVelocityTool(defaultContext, EscapeTool.class);
		addVelocityTool(defaultContext, FieldTool.class);
		addVelocityTool(defaultContext, MathTool.class);
		addVelocityTool(defaultContext, NumberTool.class);
		addVelocityTool(defaultContext, ResourceTool.class);
		addVelocityTool(defaultContext, SortTool.class);
		addVelocityTool(defaultContext, XmlTool.class);

	}

	protected VelocityContext getDefaultContext() {
		return this.defaultContext;
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public TemplateMailSender getTemplateMailSender(String confId) {
		return new TemplateMailSenderImpl(confId);
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	protected MailConfig getMailConfig(String confId) {
		return new MailConfigImpl(confId);
	}

}
