package com.risingcraft.mety.handler;

import com.risingcraft.mety.controller.dto.CMRespDto;
import com.risingcraft.mety.handler.ex.CustomApiException;
import com.risingcraft.mety.handler.ex.CustomException;
import com.risingcraft.mety.handler.ex.CustomValidationApiException;
import com.risingcraft.mety.handler.ex.CustomValidationException;
import com.risingcraft.mety.util.Script;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)  //예외를 낚아챌 어노테이션을 설정하고, 변수로 어떤 예외 클래스를 낚아챌지 넣는다.
    public String validationException(CustomValidationException e) {
        if(e.getErrorMap() == null) {
            return Script.back(e.getMessage());
        } else {
            return Script.back(e.getErrorMap().toString());
        }
    }

    @ExceptionHandler(CustomException.class)  //예외를 낚아챌 어노테이션을 설정하고, 변수로 어떤 예외 클래스를 낚아챌지 넣는다.
    public String Exception(CustomException e) {
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(CustomValidationApiException.class)
    public ResponseEntity<?> validationApiException(CustomValidationApiException e) {
        return new ResponseEntity<>(new CMRespDto<>(-1,e.getMessage(),e.getErrorMap()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(CustomApiException e) {
        return new ResponseEntity<>(new CMRespDto<>(-1,e.getMessage(),null), HttpStatus.BAD_REQUEST);
    }


}
