package com.mbc.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BoardDTO {
	private int num;
	private String title;
	private String content;
	private String id;
	private Date postdate;
	private int visitcount;
}
