package ttt;

public class GameFactory {
    public Game makeGame(Ui ui) {
        return new Game(ui);
    }
}
