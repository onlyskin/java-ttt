package ttt;

import java.io.IOException;

public interface Player {
    Integer getMove(Board board) throws IOException;

    String getMarker();
}
