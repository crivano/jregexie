package com.crivano.jregexie;

public class Ocurrence implements Comparable<Ocurrence> {

	private Class<? extends Expression> clazz;
	private int start;
	private int end;
	private String all;
	private String val;

	public Ocurrence(Class<? extends Expression> clazz, int start, int end, String all, String val) {
		this.clazz = clazz;
		this.start = start;
		this.end = end;
		this.all = all;
		this.val = val;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	// Do começo para o fim, primeiro os mais longos
	@Override
	public int compareTo(Ocurrence o) {
		int i = Integer.valueOf(this.start).compareTo(o.start);
		if (i != 0)
			return i;
		i = Integer.valueOf(this.end).compareTo(o.end);
		return -i;
	}

	public Class<? extends Expression> getClazz() {
		return clazz;
	}

	public void setClazz(Class<? extends Expression> clazz) {
		this.clazz = clazz;
	}

}
