package com.yunha.boardproject.board.service;

import com.yunha.boardproject.board.dto.PostDTO;
import com.yunha.boardproject.board.entity.Post;
import com.yunha.boardproject.board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

//    private final ModelMapper modelMapper;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;


    }


    @Transactional
    public Page<Post> showBoardList(int page) {

        Pageable pageable = PageRequest.of(page, 10);
        System.out.println("서비스 정상");

        Page<Post> boardList = boardRepository.findAll(pageable);

        return boardList;
    }


    @Transactional
    public PostDTO writePost(PostDTO newPost) {

//        boardRepository.save(modelMapper.map(newPost, Post.class));
//
//        System.out.println("service " + newPost);
//        return modelMapper.map(newPost, PostDTO.class);

        System.out.println("서비스 등록");

        return newPost;

    }

}
