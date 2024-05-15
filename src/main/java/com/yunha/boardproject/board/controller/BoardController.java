package com.yunha.boardproject.board.controller;


import com.yunha.boardproject.board.entity.Board;
import com.yunha.boardproject.board.service.BoardService;
import com.yunha.boardproject.common.dto.ResponseDTO;
import com.yunha.boardproject.common.response.Tool;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @GetMapping("/boardList")
    public ResponseEntity<ResponseDTO> showBoardList(@RequestParam int page) {

        Page<Board> boardList = boardService.showBoardList(page);

        System.out.println("컨트롤러 성공");
        System.out.println("게시글 리스트: " + boardList);
        return tool.res("성공", boardList);

    }

}
