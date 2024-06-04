package com.yunha.boardproject.board.controller;


import com.yunha.boardproject.board.dto.PostDTO;
import com.yunha.boardproject.board.entity.Post;
import com.yunha.boardproject.board.service.BoardService;
import com.yunha.boardproject.common.dto.ResponseDTO;
import com.yunha.boardproject.common.response.Tool;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

        try{

            PostDTO postDTO = boardService.writePost(newPost);
            System.out.println("등록할 게시글 : " + newPost);
            return tool.res("등록 완료", null);

        }catch (Exception e){

            return tool.resErr(HttpStatus.BAD_REQUEST,"등록 실패");

        }

    }


    /**
     * 게시글 수정
     * @return
     */
    @PutMapping("/posts/{postCode}")
    public ResponseEntity<ResponseDTO> modifyPost(@ModelAttribute PostDTO post, @PathVariable Long postCode){

        System.out.println("컨트롤러 연결");
        System.out.println("post : " + post);

        PostDTO modifyPost = boardService.modifyPost(post, postCode);

        return tool.res("수정 완료", modifyPost);

    }


    /**
     * 게시글 삭제
     * @return
     */
    @DeleteMapping("/posts/{postCode}")
    public ResponseEntity<ResponseDTO> removePost(@PathVariable Long postCode){

        int result = boardService.removePost(postCode);

        return tool.res("삭제 완료", result);

    }


    @GetMapping("/posts/{postCode}")
    public ResponseEntity<ResponseDTO> showPost(@PathVariable Long postCode){

        PostDTO postDTO = boardService.showPost(postCode);

        return tool.res("특정 게시글 조회", postDTO);
    }


    @GetMapping("/posts/{accountCode}")
    public ResponseEntity<ResponseDTO> showUserPosts(@PathVariable Long accountCode){

        

    }


}
