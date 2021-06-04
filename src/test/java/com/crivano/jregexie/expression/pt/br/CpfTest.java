package com.crivano.jregexie.expression.pt.br;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.crivano.jregexie.Expression;
import com.crivano.jregexie.Ocurrence;
import com.crivano.jregexie.expression.pt.br.Cpf;

public class CpfTest {

	@Test
	public void test1Succeed() {
		Expression e = new Cpf();
		String s = "CPF: 004.896.237-60|CPF No 00489623760|Cpf004.896.237-60";
		List<Ocurrence> l = e.extract(s);
		assertEquals(s.split("\\|").length, l.size());
		for (Ocurrence o : l) {
			assertEquals("004.896.237-60", o.getVal());
		}
	}
}
