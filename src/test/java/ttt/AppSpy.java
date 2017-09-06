package ttt;

public class AppSpy extends App {
    public boolean exitCalled;
    
    public AppSpy() {
        super(null);
        exitCalled = false;
    }

    @Override
    public void exit() {
        exitCalled = true;
    }
}
