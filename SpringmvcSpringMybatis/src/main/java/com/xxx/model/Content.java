package com.xxx.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Content {

	private Integer id;
	private String test;
	private String A;
	private String B;
	private String C;
	private String D;
	private String Answer;
	@Override
	public String toString()
	{
		return "Content [id=" + id + ", test=" + test + ", A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + ", Answer="
				+ Answer + "]";
	}
	
}