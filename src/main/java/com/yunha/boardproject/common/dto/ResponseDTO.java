package com.yunha.boardproject.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class ResponseDTO {
    private HttpStatus status; // 상태코드값
    private String message; // 응답메시지
    private Object data; // 응답데이터

    public ResponseDTO(HttpStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
