package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime writeTime;
	private Long readCnt;
	private Long goodCnt;
	private Long badCnt;
}
