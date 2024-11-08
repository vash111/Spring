package org.zerock.domain;

import java.util.Date;

import org.zerock.mapper.BoardMapper;
import org.zerock.service.BoardServiceImpl;

import lombok.Builder;
import lombok.Data;

/*CREATE TABLE tbl_board(
	    bno number(10,0),
	    title VARCHAR2(200) not null,
	    content VARCHAR2(2000) not null,
	    writer VARCHAR2(50) not null,
	    regdate DATE default sysdate,
	    updatedate date default sysdate
	);*/

@Data
//@Builder
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
}
