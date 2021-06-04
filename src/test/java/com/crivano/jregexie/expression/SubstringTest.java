package com.crivano.jregexie.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.crivano.jregexie.Expression;
import com.crivano.jregexie.Ocurrence;
import com.crivano.jregexie.expression.Substring;

public class SubstringTest {
	private static final String SUBSTRING = "Nome do Usuário";
	private static final String TEST1 = "Eu, Nome do Usuário, venho por meio desta...";

	@Test
	public void testFindSubstringSameCaseSucceed() {
		Expression e = new Substring(SUBSTRING);
		List<Ocurrence> l = e.extract(TEST1);
		assertEquals(TEST1.split("\\|").length, l.size());
		for (Ocurrence o : l) {
			assertEquals(SUBSTRING, o.getVal());
		}
	}

	@Test
	public void testFindSubstringUppercaseSucceed() {
		Expression e = new Substring(SUBSTRING);
		String s = TEST1.replaceAll(SUBSTRING, SUBSTRING.toUpperCase());
		List<Ocurrence> l = e.extract(s);
		assertEquals(s.split("\\|").length, l.size());
		for (Ocurrence o : l) {
			assertEquals(SUBSTRING.toUpperCase(), o.getVal());
		}
	}

	@Test
	public void testFindSubstringAcentoSucceed() {
		Expression e = new Substring(SUBSTRING);
		String s = TEST1.replaceAll(SUBSTRING, Substring.removeAcento(SUBSTRING));
		List<Ocurrence> l = e.extract(s);
		assertEquals(s.split("\\|").length, l.size());
		for (Ocurrence o : l) {
			assertEquals(Substring.removeAcento(SUBSTRING), Substring.removeAcento(o.getVal()));
		}
	}
}
