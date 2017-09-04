package ttt;

public class PlayerFactorySpy extends PlayerFactory {
    public String calledType;
    public String calledMarker;

    public PlayerFactorySpy() {
        this.calledType = null;
        this.calledMarker = null;
    }

    @Override
    public Player makePlayer(String type, String marker, Ui ui) {
        this.calledType = type;
        this.calledMarker = marker;
        return null;
    }
}
