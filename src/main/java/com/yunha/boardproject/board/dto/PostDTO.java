package com.yunha.boardproject.board.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostDTO {

    private Long postCode;

    private String postTitle;

    private String postContent;

    private Date postDate;

//    private String accountId;

//    private Long postWriterCode;
}
