package com.crivano.jregexie.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.crivano.jregexie.Expression;
import com.crivano.jregexie.Ocurrence;

public class Substring implements Expression {
	private Pattern p;

	public Substring(String original) {
		p = Pattern.compile(Pattern.quote(removeAcento(original.toUpperCase())));
	}

	@Override
	public List<Ocurrence> extract(String s) {
		List<Ocurrence> l = new ArrayList<>();
		Matcher m = p.matcher(removeAcento(s.toUpperCase()));
		while (m.find()) {
			String val = m.group(0);
			if (validate(val)) {
				l.add(new Ocurrence(this.getClass(), m.start(), m.end(), m.group(0), s.substring(m.start(), m.end())));
			}
		}
		return l;
	}

	public static boolean validate(String val) {
		return true;
	}

	public static String format(String val) {
		return val;
	}

	public static String removeAcento(String acentuado) {
		if (acentuado == null)
			return null;
		String temp = new String(acentuado);
		temp = temp.replaceAll("[ÃÂÁÀ]", "A");
		temp = temp.replaceAll("[ÉÈÊ]", "E");
		temp = temp.replaceAll("[ÍÌÎ]", "I");
		temp = temp.replaceAll("[ÕÔÓÒ]", "O");
		temp = temp.replaceAll("[ÛÚÙÜ]", "U");
		temp = temp.replaceAll("[Ç]", "C");
		temp = temp.replaceAll("[ãâáà]", "a");
		temp = temp.replaceAll("[éèê]", "e");
		temp = temp.replaceAll("[íìî]", "i");
		temp = temp.replaceAll("[õôóò]", "o");
		temp = temp.replaceAll("[ûúùü]", "u");
		temp = temp.replaceAll("[ç]", "c");
		return temp;
	}

}
