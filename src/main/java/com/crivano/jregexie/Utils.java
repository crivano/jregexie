package com.crivano.jregexie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.github.difflib.text.DiffRow;
import com.github.difflib.text.DiffRowGenerator;

public class Utils {
	private static final String COM_CRIVANO_JREGEXIE_EXPRESSION = "com.crivano.jregexie.expression.";

	public static List<Ocurrence> sortAndFilterOcurrences(List<Ocurrence> list) {
		List<Ocurrence> l = new ArrayList<>();
		l.addAll(list);
		Collections.sort(l);

		List<Ocurrence> l2 = new ArrayList<>();
		int lastStart = 0;
		int lastEnd = 0;
		for (Ocurrence i : l) {
			if (i.getStart() > lastEnd) {
				l2.add(i);
				lastStart = i.getStart();
				lastEnd = i.getEnd();
			}
		}
		return l2;
	}

	public static String replaceOcurrencesWithPlaceholders(String s, List<Ocurrence> ocurrences) {
		StringBuilder sb = new StringBuilder();
		int last = 0;
		for (Ocurrence o : ocurrences) {
			sb.append(s.substring(last, o.getStart()));
			sb.append("{{");
			String name = o.getClazz().getName();
			if (name.startsWith(COM_CRIVANO_JREGEXIE_EXPRESSION)) {
				sb.append("!");
				name = name.substring(COM_CRIVANO_JREGEXIE_EXPRESSION.length());
			}
			sb.append(name);
			sb.append("}}");
			last = o.getEnd();
		}
		sb.append(s.substring(last, s.length()));
		return sb.toString();
	}

	public static String diff(String sOld, String sNew) {
		// create a configured DiffRowGenerator
		DiffRowGenerator generator = DiffRowGenerator.create().showInlineDiffs(true).mergeOriginalRevised(true)
				.inlineDiffByWord(true)
				// .oldTag(f -> "~") // introduce markdown style for strikethrough
				// .newTag(f -> "**") // introduce markdown style for bold
				.build();

		// compute the differences for two test texts.
		List<DiffRow> rows = generator.generateDiffRows(Arrays.asList(sOld), Arrays.asList(sNew));

		return rows.get(0).getOldLine();
	}
}
