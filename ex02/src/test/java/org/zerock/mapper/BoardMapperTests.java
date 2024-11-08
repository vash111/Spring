package org.zerock.mapper;

import static org.junit.Assert.*;import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;

	@Test //��ü list �׽�Ʈ
	public void testGetList() {
		mapper.getList().forEach(list -> log.info(list));
	}
	
	@Test //�� �ۼ� �׽�Ʈ
	public void testInsert() {
		BoardVO board = new BoardVO();
		
		board.setTitle("���� �ۼ��ϴ� ��2");
		board.setContent("���� �ۼ��ϴ� ����2");
		board.setWriter("newbie2");
		
		mapper.insert(board);
		
		log.info("board : " + board);
	}
	
	@Test
	public void testRead() {
		Long bno = 2L;
		
		BoardVO boardVO = mapper.read(bno);
		log.info(boardVO);
	}
	
	@Test
	public void testDelete() {
		int result = mapper.delete(6L);
		
		log.info("result : " + result);
	}
	
	@Test
	public void testUpdate() {
		
		Long bno = 7L;
		
		BoardVO vo = mapper.read(bno);
		
		vo.setTitle("���� ����");
		vo.setContent("���� ����");
		vo.setWriter("�ۼ���");
		
		int result = mapper.update(vo);
		log.info("result : " + result);
		
	}
	
	@Test
	public void testPage() {
		
		Criterial cri = new Criterial(5,10);
		mapper.getListWithPage(cri).forEach(list -> log.info(list));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
