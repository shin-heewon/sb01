package com.ssg.sb01.service;

import com.ssg.sb01.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceImplTest {

    @Autowired(required = false)
    private BoardService boardService;

    @Test
    void register() {

        BoardDto boardDto = BoardDto.builder().title("테스트").writer("ssgggggggggg").content("테스트 코드 실행").build();

        boardService.register(boardDto);

    }

    @Test
    void modify(){
        BoardDto boardDto = BoardDto.builder().bno(101L).title("수정됐다").content("수정 완료됨!!!!!!").build();

        boardService.readOne(boardDto.getBno());

        boardService.modify(boardDto);
    }
}