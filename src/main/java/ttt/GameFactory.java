package ttt;

public class GameFactory {
    public Game makeGame(Ui ui, Player[] players) {
        return new Game(ui, players);
    }
}
