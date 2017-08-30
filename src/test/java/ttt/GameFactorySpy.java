package ttt;

public class GameFactorySpy extends GameFactory {
    public boolean makeGameCalled;
    public GameSpy gameSpy;

    public GameFactorySpy() {
        this.makeGameCalled = false;
    }

    @Override
    public Game makeGame(Ui ui) {
        makeGameCalled = true;
        gameSpy = new GameSpy();
        return gameSpy;
    }
}
