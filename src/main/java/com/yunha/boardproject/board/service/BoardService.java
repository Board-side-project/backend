package com.yunha.boardproject.board.service;

import com.yunha.boardproject.board.dto.PostDTO;
import com.yunha.boardproject.board.entity.Post;
import com.yunha.boardproject.board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

//    private final ModelMapper modelMapper;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Page<Post> showBoardList(int page) {

        Pageable pageable = PageRequest.of(page, 10);
        System.out.println("서비스 정상");

        Page<Post> boardList = boardRepository.findAll(pageable);

        return boardList;
    }



//    public PostDTO writePost(PostDTO newPost) {
//
////        boardRepository.save(newPost);
//
//
//        return
//    }
}
