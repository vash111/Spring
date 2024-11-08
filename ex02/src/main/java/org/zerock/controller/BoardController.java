package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("/list")
	public void list(Criterial cri , Model model) {
		log.info("list.............." + cri);
		List<BoardVO> list = service.getList(cri);
		
		model.addAttribute("list" , service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
	}
	
	@GetMapping("/register")
	public void register() {}
	
	//@RequestMapping(value = "/register", method = { RequestMethod.POST})
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		
		log.info("register........");
		service.register(vo);
		
		rttr.addFlashAttribute("result",vo.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno,Model model) {
		log.info("get................");
		
		BoardVO vo = service.get(bno);
		model.addAttribute("board",vo);
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno , RedirectAttributes rttr) {
		log.info("remove.........." + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		};
		
		return "redirect:/board/list";	
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		log.info("modify............" + vo);
		
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	
	
	
	
	
	
	
}
