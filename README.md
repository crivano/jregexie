Project JRegexIE
====
JRegexIE is a simple open-source library for Information Extraction. It applies regular expressions to identify occurrences of patterns on a string.

Main goals are:
- To be deterministic (IE usually is based on AI and the results are unpredictable)
- To be easily expanded
- To be as fast as possible

Example / Usage
====
To extract occurrences of numbes in a string, use something like:

```java
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
```

A more sophisticated example would be to extract Brazilian CPF numbers from a string, like this:

```java
public class CpfTest {
	@Test
	public void test1Succeed() {
		Expression e = new Cpf();
		String s = "CPF: 004.896.237-61|CPF No 00489623760|Cpf004.896.237-61";
		List<Ocurrence> l = e.extract(s);
		assertEquals(s.split("\\|").length, l.size());
		for (Ocurrence o : l) {
			assertEquals("004.896.237-61", o.getVal());
		}
	}
}
```

Development
====

JRegexIE is very much in-development, and is in no way, shape, or form guaranteed to be stable or bug-free.  Bugs, suggestions, or pull requests are all very welcome.

License
====
Copyright 2021 Renato Crivano

Licensed under the Apache License, Version 2.0

http://www.apache.org/licenses/LICENSE-2.0
