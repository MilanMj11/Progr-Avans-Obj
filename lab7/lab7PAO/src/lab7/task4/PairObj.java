package lab7.task4;

public class PairObj {
    int x,y;

    public PairObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
