package ttt;

import java.util.Random;

public class RandomSpy extends Random {
    public boolean nextIntCalled;

    public RandomSpy() {
        this.nextIntCalled = false;
    }

    @Override
    public int nextInt() {
        nextIntCalled = true;
        return 0;
    };
}
