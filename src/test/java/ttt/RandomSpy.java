package ttt;

import java.util.Random;

public class RandomSpy extends Random {
    public boolean nextIntCalledWith9;

    public RandomSpy() {
        this.nextIntCalledWith9 = false;
    }

    @Override
    public int nextInt(int bound) {
        if (bound == 9) {
            nextIntCalledWith9 = true;
        }
        return 0;
    };
}
