package ttt;

public class MinimaxSpy extends Minimax {
    public boolean minimaxCalled;
    public Board minimaxFirstArg;
    public String minimaxSecondArg;
    public Integer minimaxThirdArg;

    public MinimaxSpy() {
        minimaxCalled = false;
        minimaxFirstArg = null;
        minimaxSecondArg = "";
        minimaxThirdArg = null;
    }

    @Override
    public Integer[] minimax(Board board, String mainPlayerMarker, int depth) {
        minimaxCalled = true;
        minimaxFirstArg = board;
        minimaxSecondArg = mainPlayerMarker;
        minimaxThirdArg = depth;
        return new Integer[]{null, 1};
    }
}
