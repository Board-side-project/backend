package com.yunha.boardproject.security.controller;

import com.yunha.boardproject.security.dto.JoinDTO;
import com.yunha.boardproject.security.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String joinUser(JoinDTO joinDTO){

        System.out.println("받은 유저의 아이디는 : " +joinDTO.getAccountId());
        joinService.joinUser(joinDTO);

        return "회원가입 성공";
    }


}
