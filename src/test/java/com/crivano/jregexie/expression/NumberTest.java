package com.crivano.jregexie.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.crivano.jregexie.Expression;
import com.crivano.jregexie.Ocurrence;

public class NumberTest {
	private static String TEST1 = "is 123.|buy 123 apples";

	@Test
	public void testNumerosSucceed() {
		Expression e = new Number();
		List<Ocurrence> l = e.extract(TEST1);
		assertEquals(TEST1.split("\\|").length, l.size());
		for (Ocurrence o : l) {
			assertEquals("123", o.getVal());
		}
	}
}
