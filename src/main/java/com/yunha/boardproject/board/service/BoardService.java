package com.yunha.boardproject.board.service;

import com.yunha.boardproject.board.dto.PostDTO;
import com.yunha.boardproject.board.entity.Post;
import com.yunha.boardproject.board.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    public BoardService(BoardRepository boardRepository, ModelMapper modelMapper) {
        this.boardRepository = boardRepository;
        this.modelMapper = modelMapper;
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

        Post writePost = modelMapper.map(newPost, Post.class);

        boardRepository.save(writePost);

        System.out.println("service newPost : " + newPost);
        System.out.println("service writePost : " + writePost);

        return modelMapper.map(writePost, PostDTO.class);


    }


    @Transactional
    public PostDTO modifyPost(PostDTO post, Long postCode) {

        Post modifyPost = boardRepository.findById(postCode).orElseThrow();

        modifyPost.setPostTitle(post.getPostTitle());
        modifyPost.setPostContent(post.getPostContent());

        boardRepository.save(modifyPost);

        return modelMapper.map(modifyPost, PostDTO.class);

    }


    @Transactional
    public int removePost(Long postCode) {

        try{
            Post removedPost = boardRepository.findById(postCode).orElseThrow();
            boardRepository.delete(removedPost);
            return 1;
        }catch (Exception e){
            return 0;
        }


    }


    /**
     * 특정 게시글 조회
     * @param postCode
     * @return
     */
    @Transactional
    public PostDTO showPost(Long postCode) {

        Post foundPost = boardRepository.findById(postCode).orElseThrow();

        return modelMapper.map(foundPost, PostDTO.class);
        
    }
}
