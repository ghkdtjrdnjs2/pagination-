package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.Pagination;
import com.example.demo.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Validated
@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	@Autowired
	private ObjectMapper objectMapper;
	
	@GetMapping("/")
	public ModelAndView list(@RequestParam(defaultValue="1")Long pageno) {
		// 검증했을 때 @RequestParam과 @NotNull, @NotEmpty 동시에 사용 X
		// 검증할 경우 @NotNull, @NotEmpty를 사용하자
		// 단 기본값을 지정할 때는 @RequestParam
		Pagination p = service.findAll(pageno);
		return new ModelAndView("board/list").addObject("p",p);
	}
	
	@GetMapping("/board/write")
	public void write() {
		
		
	}
	
	@PostMapping("/board/write")
	public ModelAndView write(String content) {
		System.out.println(content);
		return null;
	}
}
