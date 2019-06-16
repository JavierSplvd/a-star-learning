package grid;

public class Node implements INode {

    private int x;
    private int y;

    private float fitParameter = 1000;
    private boolean isGoal = false;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void makeStarting(){
        fitParameter = 0;
    }

    @Override
    public float getF() {
        return 0;
    }

    @Override
    public float getG() {
        return 0;
    }

    @Override
    public float getH() {
        return 0;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    void makeGoal() {
        isGoal = true;
    }
}
