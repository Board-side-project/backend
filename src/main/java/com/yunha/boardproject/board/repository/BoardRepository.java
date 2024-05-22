package com.yunha.boardproject.board.repository;

import com.yunha.boardproject.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Post, Long> {


}
