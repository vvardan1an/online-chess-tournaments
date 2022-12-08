package am.itspace.onlinechesstournamentrest.exceptionHandler;

import am.itspace.onlinechesstournamentcommon.exception.UserNotFoundException;
import am.itspace.onlinechesstournamentcommon.exception.WorldChessChampionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class EntityNotFoundExceptionHandler {

    @ExceptionHandler(value = {WorldChessChampionNotFoundException.class, UserNotFoundException.class})
    public ResponseEntity<Object> notFoundExceptionHandler(RuntimeException rte) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(rte.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiExceptionResponse, notFound);
    }
}
