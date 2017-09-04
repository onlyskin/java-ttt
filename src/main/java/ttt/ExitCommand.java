package ttt;

public class ExitCommand implements Command {
    private App app;
    private Ui ui;

    public ExitCommand(App app, Ui ui) {
        this.app = app;
        this.ui = ui;
    }

    public void execute() {
        app.exit();
    }

    public boolean respondsTo(String command) {
        return command.startsWith(ui.getMessage("exitAppCommand"));
    }
}
