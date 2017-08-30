package ttt;

public class GameFactorySpy extends GameFactory {
    public Integer makeGameCallCount;
    public GameSpy gameSpy;

    public GameFactorySpy() {
        this.makeGameCallCount = 0;
    }

    @Override
    public Game makeGame(Ui ui) {
        makeGameCallCount++;
        gameSpy = new GameSpy();
        return gameSpy;
    }
}
