package com.crivano.jregexie.expression.pt.br;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.crivano.jregexie.Expression;
import com.crivano.jregexie.Ocurrence;

public class Real implements Expression {
	private static Pattern p = Pattern.compile(
			"(?<prefix>R\\$\\s*)(?<val>(?:[0-9]\\d*)(?:\\.?\\d{3})*(?:,\\d{2})?)(?<sufix>\\s*\\([\\w,\\s]+\\))?");

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

	public static boolean validate(String CPF) {
		return true;
	}

	public static String format(String val) {
		val = val.replaceAll("\\.", "");
		if (val.contains(","))
			val = val.replace(",", ".");
		BigDecimal valor = new BigDecimal(val);
		Locale ptBr = new Locale("pt", "BR");
		return NumberFormat.getCurrencyInstance(ptBr).format(valor);
	}
}
