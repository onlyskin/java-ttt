package ttt;

public class PlayerFactory {
    public Player makePlayer(String type, String marker, Ui ui) {
        if (type.equals("human")) {
            return new HumanPlayer(marker, ui);
        }
        else return new ComputerPlayer(marker);
    }
}
