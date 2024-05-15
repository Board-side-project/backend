package com.yunha.boardproject.board.repository;

import com.yunha.boardproject.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
