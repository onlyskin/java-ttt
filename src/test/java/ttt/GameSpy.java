package ttt;

public class GameSpy extends Game {
    public boolean startCalled;
    
    public GameSpy() {
        super(null, null);
        this.startCalled = false;
    }

    @Override
    public void start() {
        startCalled = true;
    }
}
