package am.itspace.onlinechesstournamentcommon.exception;

public class TimeCreationException extends RuntimeException {

    public TimeCreationException(String message) {
        super(message);
    }

    public TimeCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
