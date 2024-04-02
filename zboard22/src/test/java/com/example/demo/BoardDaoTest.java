package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.BoardDao;

@SpringBootTest
public class BoardDaoTest {
	@Autowired
	private BoardDao boardDao;
	
	//@Test
	public void countTest() {
		System.out.println(boardDao.count());
	}
	
	//@Test
	public void findAllTest() {
		assertEquals(10, boardDao.findAll(11L, 20L).size());
	}
}
