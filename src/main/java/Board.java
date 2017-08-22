package ttt;

public class Board {
    private final String[][] cells;

    public Board() {
        this.cells = new String[][]{{"-","-","-"},
                                     {"-","-","-"},
                                     {"-","-","-"}};
    }

    public Board(String[][] cells) {
        this.cells = cells;
    }

    public boolean won(String m) {
        String[][] c = cells;
        if (
            (c[0][0].equals(m) && c[0][1].equals(m) && c[0][2].equals(m)) ||
            (c[1][0].equals(m) && c[1][1].equals(m) && c[1][2].equals(m)) ||
            (c[2][0].equals(m) && c[2][1].equals(m) && c[2][2].equals(m)) ||
            (c[0][0].equals(m) && c[1][0].equals(m) && c[2][0].equals(m)) ||
            (c[0][1].equals(m) && c[1][1].equals(m) && c[2][1].equals(m)) ||
            (c[0][2].equals(m) && c[1][2].equals(m) && c[2][2].equals(m)) ||
            (c[0][0].equals(m) && c[1][1].equals(m) && c[2][2].equals(m)) ||
            (c[0][2].equals(m) && c[1][1].equals(m) && c[2][0].equals(m))
           ) {
            return true;
        }
        return false;
    }
}
