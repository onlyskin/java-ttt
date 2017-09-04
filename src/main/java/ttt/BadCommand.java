package ttt;

public class BadCommand implements Command {
    private Ui ui;

    public BadCommand(Ui ui) {
        this.ui = ui;
    }

    public void execute() {
        ui.printMessage("invalidCommand");
    }

    public boolean respondsTo(String command) {
        return true;
    }
}