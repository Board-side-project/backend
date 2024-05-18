package com.yunha.boardproject.board.controller;


import com.yunha.boardproject.board.entity.Board;
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
    @GetMapping("/boardList")
    public ResponseEntity<ResponseDTO> showBoardList(@RequestParam int page) {

        Page<Board> boardList = boardService.showBoardList(page);

        System.out.println("컨트롤러 성공");
        System.out.println("게시글 리스트: " + boardList);
        return tool.res("성공", boardList);

    }


    /**
     * 게시글 등록 메소드
     * @return
     */
    @PostMapping("/write")
    public ResponseEntity<ResponseDTO> writeBoard(){


        return tool.res("등록 완료", null);

    }


    /**
     * 게시글 수정
     * @return
     */
    @PutMapping("/write")
    public ResponseEntity<ResponseDTO> modifyBoard(){



        return tool.res("수정 완료", null);

    }


    /**
     * 게시글 삭제
     * @return
     */
    @DeleteMapping("/write")
    public ResponseEntity<ResponseDTO> removeBoard(){


        return tool.res("삭제 완료", null);

    }


}
