package am.itspace.onlinechesstournamentcommon.exception;

public class WorldChessChampionNotFoundException extends RuntimeException {

    public WorldChessChampionNotFoundException(String message) {
        super(message);
    }

    public WorldChessChampionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
