package am.itspace.onlinechesstournaments.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException(UserNotFoundException ex) {
        return "error";
    }

//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<?> illegalArgumentException(IllegalArgumentException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
}
