package com.crivano.jregexie.expression.pt.br;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.crivano.jregexie.Expression;
import com.crivano.jregexie.Ocurrence;
import com.crivano.jregexie.expression.pt.br.Real;

public class RealTest {
	private static String TEST1 = "R$1.234,56|R$1234,56|R$ 1234,56 (hum mil, duzentos e trinta e quatro reais e cinquenta e seis centavos)";

	@Test
	public void testComCentavosSucceed() {
		Expression e = new Real();
		List<Ocurrence> l = e.extract(TEST1);
		assertEquals(TEST1.split("\\|").length, l.size());
		for (Ocurrence o : l) {
			assertEquals("R$ 1.234,56", o.getVal());
		}
	}

	@Test
	public void testSemCentavosSucceed() {
		Expression e = new Real();
		String s = TEST1.replaceAll(",56", "");
		List<Ocurrence> l = e.extract(s);
		assertEquals(s.split("\\|").length, l.size());
		for (Ocurrence o : l) {
			assertEquals("R$ 1.234,00", o.getVal());
		}
	}
}
