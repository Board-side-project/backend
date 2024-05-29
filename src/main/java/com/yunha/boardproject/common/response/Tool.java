package com.yunha.boardproject.common.response;

import com.yunha.boardproject.common.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Tool {

    /**
     * 에러를 갖고 응답하는 메소드
     * @param errorCode 에러코드
     * @param message 메세지
     * @return 에러코드,메세지,null 로 응답
     */
    public ResponseEntity<ResponseDTO> resNull(HttpStatus errorCode, String message){
        return ResponseEntity.ok().body(new ResponseDTO(errorCode, message,null));
    }

    /**
     * 정상적으로 응답하는 메소드
     * @param msg 메세지
     * @param data 보낼 데이터
     * @return 200, 메세지, 보낼데이터 로 응답
     */
    public ResponseEntity<ResponseDTO> res(String msg,Object data){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,msg,data));
    }
    public ResponseEntity<ResponseDTO> resErr(HttpStatus status, String msg){
        return ResponseEntity.ok().body(new ResponseDTO(status,msg,null));
    }

}
