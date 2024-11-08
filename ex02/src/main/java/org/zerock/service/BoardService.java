package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

//사용자 친화적인

@Service
public interface BoardService {
	
	public void register(BoardVO vo);
	
	public BoardVO get(Long bon);
	
	public boolean modify(BoardVO vo);
	
	public boolean remove(Long bno);
	
	//public List<BoardVO> getList();
	public List<BoardVO> getList(Criterial cri);
}
