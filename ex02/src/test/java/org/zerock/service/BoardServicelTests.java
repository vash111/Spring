package org.zerock.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

import lombok.Builder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServicelTests {

	@Autowired
	private BoardService service;

	@Test
	public void testRegister() {

		
		/*
		 * BoardVO vo = BoardVO.builder() .title("빌더로 작성하는 글") .content("빌더로 작성하는 내용")
		 * .writer("빌더") .build();
		 * 
		 * service.register(vo);
		 * 
		 * log.info("생성된 게시물 번호 : " + vo.getBno());
		 */
		 
	}

	@Test
	public void testGetList() {
		
		/*
		 * List<BoardVO> list = service.getList();
		 * 
		 * list.forEach(vo -> log.info(vo));
		 * 
		 * 
		 * service.getList().forEach(vo -> log.info(vo));
		 */
	}

	@Test
	public void getRead() {
		log.info(service.get(12L));
	}

	@Test
	public void testRemove() {
		log.info("====================" + service.remove(13L));
	}

	@Test
	public void testModify() {
		BoardVO vo = service.get(10L);

		vo.setTitle("수정 제목");
		vo.setContent("수정 내용");
		vo.setWriter("modify");

		log.info(service.modify(vo));

	}

}
