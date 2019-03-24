package com.windwagon.viviane;

import java.io.IOException;

import org.fusesource.jansi.Ansi;
import org.springframework.stereotype.Component;

import jline.console.ConsoleReader;

@Component
public class ShellConsole {

	private ConsoleReader console() throws IOException {
		return new ConsoleReader();
	}

	public void beep() throws IOException {
		console().beep();
	}

	public void clearScreen() throws IOException {
		console().clearScreen();
	}

	public void print(CharSequence str) throws IOException {
		System.out.print(str);
	}

	public void println(CharSequence str) throws IOException {
		System.out.println(str);
	}

	public String readLine(String prompt) throws IOException {
		return console().readLine(prompt);
	}

	public String readLine(Character mask) throws IOException {
		return console().readLine(mask);
	}

	public String readLine(String prompt, Character mask) throws IOException {
		return console().readLine(prompt, mask);
	}

	private Ansi add(Ansi ansi, Ansi.Color color, String smt) {
		return ansi.fg(color).a(smt).fg(Ansi.Color.WHITE);
	}

	public String request(String what, String format, String currentValue, String defaultValue) throws IOException {

		if (currentValue != null) return currentValue;

		Ansi ansiPrompt = add(Ansi.ansi(), Ansi.Color.RED, what + " ");
		if (format != null) add(ansiPrompt, Ansi.Color.GREEN, "(" + format + ") ");
		add(ansiPrompt, Ansi.Color.RED, "? ");
		if (defaultValue != null) add(ansiPrompt, Ansi.Color.BLUE, "[" + defaultValue + "] ");

		String value = readLine(ansiPrompt.toString());

		if ((value == null || value.isEmpty()) && defaultValue != null) value = defaultValue;

		return value;

	}

	public String request(String what, String currentValue, String defaultValue) throws IOException {
		return request(what, currentValue, defaultValue);
	}

	public Integer request(String what, Integer cur, Integer def) throws IOException {

		String val = request(what, null, cur == null ? null : cur.toString(), def == null ? null : def.toString());

		return val == null ? null : Integer.valueOf(val);

	}

}
