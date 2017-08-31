package ttt;

import java.io.IOException;

public class HumanPlayer implements Player {
    private Ui ui;
    private String marker;

    public HumanPlayer(String marker, Ui ui) {
        this.ui = ui;
        this.marker = marker;
    }

    public Integer getMove(Board board) throws IOException {
        return ui.getMove(board);
    }
    
    public String getMarker() {
        return this.marker;
    }
}
