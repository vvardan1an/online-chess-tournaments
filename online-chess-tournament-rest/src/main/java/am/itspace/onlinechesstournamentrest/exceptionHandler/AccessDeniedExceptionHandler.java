package am.itspace.onlinechesstournamentrest.exceptionHandler;

import am.itspace.onlinechesstournamentcommon.exception.AccessDeniedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class AccessDeniedExceptionHandler {

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<Object> accessDeniedExceptionHandler(RuntimeException e) {
        HttpStatus accessDenied = HttpStatus.FORBIDDEN;
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(e.getMessage(),
                accessDenied, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiExceptionResponse, accessDenied);
    }
}
