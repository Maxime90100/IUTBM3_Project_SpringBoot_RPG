package fr.iutbm.theveneau.maxime.rpg.control.exceptions;

import fr.iutbm.theveneau.maxime.rpg.model.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorDTO resourceNotFoundHandler(ResourceNotFoundException ex) {
        return new ErrorDTO(ex.getErrorNumber(), ex.getContext(), ex.getMessage());
    }
}
