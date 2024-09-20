package com.ssg.sb01.repository;

import com.ssg.sb01.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}

//JpaRepository 인터페이스를 상속할때에는 엔티티 타입과 @Id 타입을 지정해 주어야 한다.