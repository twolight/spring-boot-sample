package com.twolight.server.contoller;

import com.twolight.server.common.exception.InvalidTokenException;
import com.twolight.server.common.utils.ResponseUtil;
import com.twolight.server.response.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionController {

    @ExceptionHandler(value = InvalidTokenException.class)
    public Response exception(InvalidTokenException exception) {
        return ResponseUtil.invalidToken();
    }

}
