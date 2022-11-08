package am.itspace.onlinechesstournaments.exception.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizerException extends Exception{

    private int code;

    public OrganizerException(int code) {
        this.code = code;
    }
}
