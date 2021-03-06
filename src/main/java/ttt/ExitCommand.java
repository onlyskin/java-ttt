package ttt;

public class ExitCommand implements Command {
    private final App app;
    private final Ui ui;

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

    public String getTitle() {
        return "exit";
    }
}
