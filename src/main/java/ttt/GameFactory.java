package ttt;

public class GameFactory {
    Player[] players;

    public Game makeGame(Ui ui, Player[] players) {
        return new Game(ui, players);
    }
}
