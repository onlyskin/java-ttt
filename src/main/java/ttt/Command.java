package ttt;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;

    boolean respondsTo(String command);
}
