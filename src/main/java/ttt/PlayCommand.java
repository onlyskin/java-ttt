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
        Player player1 = ui.getPlayer();
        Player player2 = ui.getPlayer();
        Player[] players = new Player[]{player1, player2};
        Game game = gameFactory.makeGame(ui, players);
        game.start();
        ui.printMessage("appMenu");
    }

    public boolean respondsTo(String command) {
        return command.startsWith(ui.getMessage("playAppCommand"));
    }
}
