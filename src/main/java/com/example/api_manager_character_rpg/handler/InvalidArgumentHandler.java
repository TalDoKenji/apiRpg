package com.example.api_manager_character_rpg.handler;

import com.example.api_manager_character_rpg.DTO.ErrorDTO;
import com.example.api_manager_character_rpg.exception.InvalidArgument;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@AllArgsConstructor
@Data
public class InvalidArgumentHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(InvalidArgument.class)
    public ErrorDTO invalidArgument(InvalidArgument ex){
        return new ErrorDTO(
                ex.getMessage()
        );
    }
}
