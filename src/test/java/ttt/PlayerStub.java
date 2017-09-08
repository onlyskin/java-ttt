package ttt;

public class PlayerStub implements Player {
    String marker;

    public PlayerStub(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return marker;
    }

    public Integer getMove(Board board) {
        return null;
    }

}
