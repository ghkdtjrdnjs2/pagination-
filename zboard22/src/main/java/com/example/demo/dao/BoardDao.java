package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BoardListDto;
import com.example.demo.entity.Board;

// 스프링 어노테이션은 원래 레파지토리인데 인터페이스가 객체를 만들지 못하기때문에 맵퍼를 쓴다

@Mapper
public interface BoardDao {
	public long count();
	
	public List<BoardListDto> findAll(Long startRownum, Long endRownum);
}
