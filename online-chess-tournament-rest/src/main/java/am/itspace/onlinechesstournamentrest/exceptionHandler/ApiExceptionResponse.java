package am.itspace.onlinechesstournamentrest.exceptionHandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class ApiExceptionResponse {

    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public ApiExceptionResponse(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }
}
