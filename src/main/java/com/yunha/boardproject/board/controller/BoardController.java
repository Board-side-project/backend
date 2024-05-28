package com.yunha.boardproject.board.controller;


import com.yunha.boardproject.board.dto.PostDTO;
import com.yunha.boardproject.board.entity.Post;
import com.yunha.boardproject.board.service.BoardService;
import com.yunha.boardproject.common.dto.ResponseDTO;
import com.yunha.boardproject.common.response.Tool;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {


    private final BoardService boardService;

    private final Tool tool;

    public BoardController(BoardService boardService, Tool tool) {
        this.boardService = boardService;
        this.tool = tool;
    }



    /**
     * 게시글 리스트 조회 메소드
     * @return
     */
    @GetMapping("/posts")
    public ResponseEntity<ResponseDTO> showBoardList(@RequestParam int page) {

        Page<Post> boardList = boardService.showBoardList(page);

        System.out.println("컨트롤러 성공");
        System.out.println("게시글 리스트 조회: " + boardList);
        return tool.res("조회 성공", boardList);

    }


    /**
     * 게시글 등록 메소드
     * @return
     */
    @PostMapping("/posts")
    public ResponseEntity<ResponseDTO> writePost(@ModelAttribute PostDTO newPost){

        System.out.println("컨트롤러 연결");
        PostDTO postDTO = boardService.writePost(newPost);
        System.out.println("등록된 게시글 : " + postDTO);

        return tool.res("등록 완료", postDTO);

    }


    /**
     * 게시글 수정
     * @return
     */
    @PutMapping("/posts/{postCode}")
    public ResponseEntity<ResponseDTO> modifyPost(){

        // 게시글code 받기

        return tool.res("수정 완료", null);

    }


    /**
     * 게시글 삭제
     * @return
     */
    @DeleteMapping("/posts/{postCode}")
    public ResponseEntity<ResponseDTO> removePost(){


        return tool.res("삭제 완료", null);

    }


    @GetMapping("/posts/{postCode}")
    public ResponseEntity<ResponseDTO> showPost(){

        return tool.res("특정 게시글 조회", null);
    }


}
