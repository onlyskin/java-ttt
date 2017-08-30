package ttt;

public class UiSpy extends Ui {
    public String printMessageCalledWith;

    public UiSpy() {
        super(null, null);
        this.printMessageCalledWith = null;
    }

    @Override
    public void printMessage(String id) {
        printMessageCalledWith = id;
    }
}
