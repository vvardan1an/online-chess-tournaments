package am.itspace.onlinechesstournamentrest.exceptionHandler;

import am.itspace.onlinechesstournamentcommon.exception.TimeCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CreationExceptionHandler {

    @ExceptionHandler(value = TimeCreationException.class)
    public ResponseEntity<Object> creationExceptionHandler(RuntimeException e) {
        HttpStatus expectationFailed = HttpStatus.EXPECTATION_FAILED;
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(e.getMessage(),
                expectationFailed,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiExceptionResponse, expectationFailed);
    }
}
