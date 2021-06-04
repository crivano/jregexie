package com.crivano.jregexie.expression.pt.br;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.crivano.jregexie.Expression;
import com.crivano.jregexie.Ocurrence;
import com.crivano.jregexie.Utils;
import com.crivano.jregexie.expression.Number;
import com.crivano.jregexie.expression.Substring;

public class Tudo implements Expression {
	private Pattern p;
	private String[] substrings;

	public Tudo(String... substrings) {
		this.substrings = substrings;
	}

	@Override
	public List<Ocurrence> extract(String s) {
		List<Ocurrence> l = new ArrayList<>();
		l.addAll(new Cpf().extract(s));
		l.addAll(new Number().extract(s));
		l.addAll(new Real().extract(s));
		if (substrings != null)
			for (String substring : substrings)
				l.addAll(new Substring(substring).extract(s));
		return Utils.sortAndFilterOcurrences(l);
	}

	public static boolean validate(String val) {
		return true;
	}

	public static String format(String val) {
		return val;
	}
}
