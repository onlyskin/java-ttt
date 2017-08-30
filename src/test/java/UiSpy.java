package ttt;

public class UiSpy extends Ui {
    public boolean printMessageCalledWithWelcome;
    public boolean printMessageCalledWithGoodbye;
    public boolean getInputCalled;

    public UiSpy() {
        super(null, null);
        this.printMessageCalledWithWelcome = false;
        this.printMessageCalledWithGoodbye = false;
        this.getInputCalled = false;
    }

    @Override
    public void printMessage(String id) {
        if (id == "welcome") printMessageCalledWithWelcome = true;
        else if (id == "goodbye") printMessageCalledWithGoodbye = true;
    }

    @Override
    public String getInput() {
        getInputCalled = true;
        return "";
    }
}
