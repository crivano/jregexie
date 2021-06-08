package com.crivano.jregexie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UtilsDiff {
	private static String TEST1 = "buy 1 apple";
	private static String TEST2 = "buy 2 apples";

	@Test
	public void testSimpleDiffSucceed() {
		String s = Utils.diff(TEST1, TEST2);
		assertEquals(
				"buy <span class=\"editOldInline\">1</span><span class=\"editNewInline\">2</span> <span class=\"editOldInline\">apple</span><span class=\"editNewInline\">apples</span>",
				s);
	}

	@Test
	public void testSimpleDiffAndColapseSucceed() {
		String s = Utils.diffAndColapse(TEST1, TEST2);
		assertEquals(
				"buy <span class=\"replaceInline\" title=\"1\">2</span> <span class=\"replaceInline\" title=\"apple\">apples</span>",
				s);
	}

	@Test
	public void testSimpleDiffAndColapseExtremeSucceed() {
		String s = Utils.diffAndColapse("Condeno o réu ao pagamento de 20 salários mínimos.",
				"Determino pagamento de 3 salários mínimos.");
		assertEquals(
				"<span class=\"replaceInline\" title=\"Condeno\">Determino</span> <span class=\"editOldInline\">o réu ao </span>pagamento de <span class=\"replaceInline\" title=\"20\">3</span> salários mínimos.",
				s);
	}

}
