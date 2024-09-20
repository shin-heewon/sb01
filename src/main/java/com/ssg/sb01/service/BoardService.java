package com.ssg.sb01.service;

import com.ssg.sb01.dto.BoardDto;

public interface BoardService {

    Long register(BoardDto boardDto);
    BoardDto readOne(Long bno);
    void modify(BoardDto boardDto);
    void remove(Long bno);

}
