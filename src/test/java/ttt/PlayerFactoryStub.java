package ttt;

public class PlayerFactoryStub extends PlayerFactory {
    public PlayerFactoryStub() {}

    @Override
    public Player makePlayer(String type, String marker, Ui ui) {
        return new PlayerStub("X");
    }
}
