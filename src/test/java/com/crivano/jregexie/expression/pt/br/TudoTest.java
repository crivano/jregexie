package com.crivano.jregexie.expression.pt.br;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.crivano.jregexie.Ocurrence;
import com.crivano.jregexie.Utils;

@TestInstance(Lifecycle.PER_CLASS)
public class TudoTest {
	private static final String SUBSTRING = "Nome do Usuário";
	private static final String CPF = "004.896.237-60";
	private static final String NUMEROS = "12";
	private static final String REAIS = "R$ 1.234,56";

	private static final String TEST1 = "Eu, Nome do Usuário, CPF: " + CPF + ", solicito restituição de " + NUMEROS
			+ " parcelas de " + REAIS + "...";

	private List<Ocurrence> ocurrences;

	@BeforeAll
	public void before() {
		this.ocurrences = new Tudo(SUBSTRING).extract(TEST1);
	}

	@Test
	public void testFindMultipleSucceed() {
		assertEquals(SUBSTRING, ocurrences.get(0).getVal());
		assertEquals(CPF, ocurrences.get(1).getVal());
		assertEquals(NUMEROS, ocurrences.get(2).getVal());
		assertEquals(REAIS, ocurrences.get(3).getVal());
	}

	@Test
	public void testReplaceMultipleSucceed() {
		String s = Utils.replaceOcurrencesWithPlaceholders(TEST1, ocurrences);
		assertEquals(TEST1.replace(SUBSTRING, "{{!Substring}}").replace("CPF: " + CPF, "{{!pt.br.Cpf}}")
				.replace(NUMEROS, "{{!Number}}").replace(REAIS, "{{!pt.br.Real}}"), s);
	}

}
