package com.crivano.jregexie.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.crivano.jregexie.Expression;
import com.crivano.jregexie.Ocurrence;

public class Number implements Expression {
	private static Pattern p = Pattern.compile("(?<val>[0-9]+)");

	@Override
	public List<Ocurrence> extract(String s) {
		List<Ocurrence> l = new ArrayList<>();
		Matcher m = p.matcher(s);
		while (m.find()) {
			String val = m.group("val");
			if (validate(val)) {
				l.add(new Ocurrence(this.getClass(), m.start(), m.end(), m.group(0), format(val)));
			}
		}
		return l;
	}

	public static boolean validate(String s) {
		return true;
	}

	public static String format(String val) {
		return val;
	}
}
