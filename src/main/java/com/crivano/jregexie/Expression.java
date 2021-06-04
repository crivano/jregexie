package com.crivano.jregexie;

import java.util.List;

public interface Expression {
	List<Ocurrence> extract(String s);
}
