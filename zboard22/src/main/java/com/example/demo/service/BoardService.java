package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.BoardListDto;
import com.example.demo.dto.Pagination;

@Service
public class BoardService {
	@Autowired
	private BoardDao Dao;
	@Value("10")
	private Long 페이지당글개수;
	@Value("5")
	private Long 블록당페이지개수;
	// 사용자가 페이지 번호를 주면
	// 출력 : List<Board>, prev, start, end, next, pageno
	
	public Pagination findAll(Long pageno) {
		// 1. pageno		startRownum		endRownum	(pageno-1)*10+1
		// 	1			1				10				0		1	
		//	2			11				20				10		11
		//	3			21				30				20		21
		Long startRownum = (pageno-1)*페이지당글개수+1;
		Long endRownum = startRownum + 페이지당글개수-1;
		List<BoardListDto> list = Dao.findAll(startRownum, endRownum);
	
		// 2. 페이지의 개수를 계산
		// 글의개수	페이지의개수	글의개수/10+1 (글의개수-1)/10+1
		// 118		12			12			12
		// 119		12			12			12
		// 120		12			13			12
		// 121		13			13			13
		Long count = Dao.count();
		Long 페이지개수 = (count-1)/페이지당글개수+1;
		
		// 3. prev, start, end, next를 계산 - 페이지의 개수 13개라면
		// pageno 		prev		start		end		next
		// 1-5			0			1			5		6
		// 6-10			5			6			10		11
		// 11-13		10			11			13		0
		
		Long prev = (pageno-1)/블록당페이지개수 * 블록당페이지개수;
		Long start = prev+1;
		Long end = prev+블록당페이지개수;
		Long next = end+1;		
		
		
		// 4. end가 페이지의 개수보다 같거나 크다면 end, next로 바꿔라
		if(end>=페이지개수) {
			end=페이지개수;
			next = 0L;
		}
		return new Pagination(list, prev, start, end, next, pageno);
	}
}
