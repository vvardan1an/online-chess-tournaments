package am.itspace.onlinechesstournamentcommon.exception;

public class OrganizerNotFoundException extends RuntimeException {

    public OrganizerNotFoundException(String message) {
        super(message);
    }

    public OrganizerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
