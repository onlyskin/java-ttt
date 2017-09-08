package ttt;

import java.io.IOException;

public class CliMenuSpy extends CliMenu {
    public boolean displayMenuCalled;
    
    public CliMenuSpy() {
        super(null, null);
        this.displayMenuCalled = false;
    }

    @Override
    public void displayMenu() throws IOException {
        displayMenuCalled = true;
    }
}
