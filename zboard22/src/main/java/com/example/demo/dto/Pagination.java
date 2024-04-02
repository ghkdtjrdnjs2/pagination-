package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pagination {
	private List<BoardListDto> list;
	private Long prev;
	private Long start;
	private Long end;
	private Long next;
	private Long pageno;
	
}
