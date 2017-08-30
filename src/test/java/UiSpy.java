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
    public boolean printMessageCalledWithGameInstructions;
    public boolean printMessageCalledWithInvalidAppCommand;
    public boolean getInputCalled;

    public UiSpy(String fakeInput) {
        super(null, null);
        InputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        reader = new BufferedReader(new InputStreamReader(inputStream));
        this.printMessageCalledWithWelcome = false;
        this.printMessageCalledWithGoodbye = false;
        this.printMessageCalledWithGameInstructions = false;
        this.printMessageCalledWithInvalidAppCommand = false;
        this.getInputCalled = false;
    }

    @Override
    public void printMessage(String id) {
        if (id == "welcome") printMessageCalledWithWelcome = true;
        else if (id == "goodbye") printMessageCalledWithGoodbye = true;
        else if (id == "gameInstructions") printMessageCalledWithGameInstructions = true;
        else if (id == "invalidAppCommand") printMessageCalledWithInvalidAppCommand = true;
    }

    @Override
    public String getInput() throws IOException {
        getInputCalled = true;
        return reader.readLine();
    }
}
