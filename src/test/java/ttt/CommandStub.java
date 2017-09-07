package ttt;

public class CommandStub implements Command {
    String title;
    public boolean executeCalled;

    public CommandStub(String title) {
        this.title = title;
        this.executeCalled = false;
    }

    public boolean respondsTo(String command) { return false; }

    public void execute() {
        executeCalled = true;
    }

    public String getTitle() {
        return title;
    }
}
