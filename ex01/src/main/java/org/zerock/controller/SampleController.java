package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample") //반복을 줄일수있음
public class SampleController {
	
    //@RequestMapping("/sample/") //GET방식
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    //@GetMapping("/smaple/")
    //@PostMapping("/sample/")
	public void basic() {
		log.info("baic..........................");
	}
	
	@GetMapping("basicOnlyGet")
	public void basic2() {
		log.info("basic get only get2.................");
	}
	
	@GetMapping("/ex01") //매개변수를 객채로 값 전달
	public String ex01(SampleDTO dto) {
		log.info(dto + "");
		log.info(dto.getName());
		log.info(dto.getAge());
		
		return "ex01";
	}
	
	@GetMapping("/ex02") //매개변수를 기본 자료형 값 전달
	//public String ex02(String name,int age) {    방법1
	public String ex02(@RequestParam("name") String a ,@RequestParam("age")int b) { // 방법2
		log.info(a);
		log.info(b);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List (@RequestParam("ids") ArrayList<String> ids) {
		log.info( "ids" + ids);
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("ex02Array : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTO list) {
		log.info("list : "+list);
		return "ex02Bean";
	}
	
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateFormat, false)); }
	 */
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : " + todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {
		log.info("dto : " + dto);
		log.info("page : " + page);
		return "sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05...........");
	}
	
	//@ResponseBody --> 응답을 json type으로 전달
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06...............");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("홍길동");
		dto.setAge(35);
		
		return dto;
				
	}
	
	// @ResponseBody : 자바객체 -> json
	// @RequestBody : json -> 자바객체
	// @ModelAttribute :컨트롤러의 메소드 파라미터나 객체를 자바에 생성해줌
	
	
	//@RequestBody
	@PostMapping("/ex06_1")
	public String ex06_1(@RequestBody SampleDTO dto) {

		log.info("/ex06_1...............");
		log.info("dto : " + dto);
		
		return "ex06_1";
	}
	
	@PostMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07..............");
		
		//{"name" : "홍길동"}
		String msg = "{\"name\": \"홍길동\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
		return new ResponseEntity<>(msg,headers,HttpStatus.OK);
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload.................");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file->{
			log.info("================");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		});
	}
	
	
	
}
