package ttt;

import java.io.IOException;

public class App {
    private final Ui ui;
    
    public App(Ui ui) {
        this.ui = ui;
    }

    public void run() throws IOException {
        ui.getInput();
    };

    public void exit() {};
}
