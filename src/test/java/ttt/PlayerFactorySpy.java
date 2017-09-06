package ttt;

import java.util.List;
import java.util.ArrayList;

public class PlayerFactorySpy extends PlayerFactory {
    public Integer makePlayerCalledCount;
    public List<String> calledWithType;

    public PlayerFactorySpy() {
        this.makePlayerCalledCount = 0;
        this.calledWithType = new ArrayList<String>();
    }

    @Override
    public Player makePlayer(String type, String marker, Ui ui) {
        this.makePlayerCalledCount++;
        this.calledWithType.add(type);
        return null;
    }
}
