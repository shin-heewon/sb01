package com.ssg.sb01.service;

import com.ssg.sb01.domain.Board;
import com.ssg.sb01.dto.BoardDto;
import com.ssg.sb01.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional //한 번에 하나씩만 작업 되도록 트랜잭션 처리, 크리티컬 섹션? 방지
public class BoardServiceImpl implements BoardService{

    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    @Override
    public Long register(BoardDto boardDto) {
        Board board = modelMapper.map(boardDto, Board.class);
        Long bno = boardRepository.save(board).getBno();//jpa 하이버네이트가 제공해주는 save 메소드

        return bno;
    }

    @Override
    public BoardDto readOne(Long bno) {
        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();
        BoardDto boardDto = modelMapper.map(board, BoardDto.class);

        return boardDto;
    }

    @Override
    public void modify(BoardDto boardDto) {
        Optional<Board> result = boardRepository.findById(boardDto.getBno());//해당 글이 존재하는지를 먼저 확인
        Board board = result.orElseThrow();
        board.change(boardDto.getTitle(), boardDto.getContent());//제목과 내용만 변경 가능함
        boardRepository.save(board);
    }

    @Override
    public void remove(Long bno) {
        boardRepository.deleteById(bno);
    }
}
