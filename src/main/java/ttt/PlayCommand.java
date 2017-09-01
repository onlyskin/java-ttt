package ttt;

import java.io.IOException;

public class PlayCommand implements Command {
    private Ui ui;
    private GameFactory gameFactory;

    public PlayCommand(Ui ui, GameFactory gameFactory) {
        this.ui = ui;
        this.gameFactory = gameFactory;
    } 

    public void execute() throws IOException {
        HumanPlayer humanPlayer1 = new HumanPlayer("X", ui);
        HumanPlayer humanPlayer2 = new HumanPlayer("O", ui);
        Player[] players = new Player[]{humanPlayer1, humanPlayer2};
        Game game = gameFactory.makeGame(ui, players);
        game.start();
        ui.printMessage("appMenu");
    }

    public boolean respondsTo(String command) {
        return command.startsWith(ui.getMessage("playAppCommand"));
    }
}
