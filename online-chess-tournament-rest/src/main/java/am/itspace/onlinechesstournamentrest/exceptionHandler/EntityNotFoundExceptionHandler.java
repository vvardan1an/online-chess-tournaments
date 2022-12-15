package am.itspace.onlinechesstournamentrest.exceptionHandler;

import am.itspace.onlinechesstournamentcommon.exception.OrganizerNotFoundException;
import am.itspace.onlinechesstournamentcommon.exception.PlayerNotFoundException;
import am.itspace.onlinechesstournamentcommon.exception.TournamentNotFoundException;
import am.itspace.onlinechesstournamentcommon.exception.WorldChessChampionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class EntityNotFoundExceptionHandler {

    @ExceptionHandler(value = {WorldChessChampionNotFoundException.class, TournamentNotFoundException.class,
            PlayerNotFoundException.class, OrganizerNotFoundException.class})
    public ResponseEntity<Object> notFoundExceptionHandler(RuntimeException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiExceptionResponse, notFound);
    }
}
