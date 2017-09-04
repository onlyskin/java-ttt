package ttt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UiSpy extends Ui {
    public BufferedReader reader;
    public boolean printMessageCalledWithWelcome;
    public boolean printMessageCalledWithGoodbye;
    public Integer appMenuCallCount;
    public boolean printMessageCalledWithInvalidCommand;
    public boolean getInputCalled;
    public boolean getMoveCalled;

    public UiSpy(String fakeInput) {
        super(null, null, null);
        InputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        reader = new BufferedReader(new InputStreamReader(inputStream));
        this.printMessageCalledWithWelcome = false;
        this.printMessageCalledWithGoodbye = false;
        this.appMenuCallCount = 0;
        this.printMessageCalledWithInvalidCommand = false;
        this.getInputCalled = false;
        this.getMoveCalled = false;
    }

    @Override
    public void printMessage(String id) {
        if (id == "welcome") printMessageCalledWithWelcome = true;
        else if (id == "goodbye") printMessageCalledWithGoodbye = true;
        else if (id == "appMenu") {
            appMenuCallCount++;
        }
        else if (id == "invalidCommand") printMessageCalledWithInvalidCommand = true;
    }

    @Override
    public String getInput() throws IOException {
        getInputCalled = true;
        return reader.readLine();
    }

    @Override
    public Integer getMove(Board board) throws IOException {
        getMoveCalled = true;
        return Integer.parseInt(reader.readLine());
    }
}
