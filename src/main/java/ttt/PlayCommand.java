package ttt;

import java.io.IOException;

public class PlayCommand implements Command {
    private Ui ui;
    private GameFactory gameFactory;
    private PlayerFactory playerFactory;

    public PlayCommand(Ui ui, GameFactory gameFactory,
            PlayerFactory playerFactory) {
        this.ui = ui;
        this.gameFactory = gameFactory;
        this.playerFactory = playerFactory;
    } 

    private Player getPlayer(String marker) throws IOException {
        String type = ui.getPlayerType();
        Player player = playerFactory.makePlayer(type, marker, ui);
        return player;
    }

    public void execute() throws IOException {
        Player player1 = getPlayer("X");
        Player player2 = getPlayer("O");
        Player[] players = new Player[]{player1, player2};
        Game game = gameFactory.makeGame(ui, players);
        game.start();
        ui.printMessage("appMenu");
    }

    public boolean respondsTo(String command) {
        return command.startsWith(ui.getMessage("playAppCommand"));
    }
}
