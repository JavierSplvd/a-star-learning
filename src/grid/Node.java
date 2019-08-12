package grid;

import java.util.List;

public class Node implements INode {

    private final String name;
    private int x;
    private int y;

    private float gScore = 1000000;
    private float heuristic = 0;

    private boolean isGoal = false;

    private List<INode> neighbors;
    private INode cameFromNode = null;


    Node(int x, int y, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public void setNeighbors(List<INode> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public void makeStarting() {
        gScore = 0;
    }

    @Override
    public float getF() {
        return gScore+heuristic;
    }

    @Override
    public float getG() {
        return gScore;
    }

    @Override
    public float getH() {
        return heuristic;
    }

    @Override
    public void setG(float g) {
        this.gScore = g;
    }

    @Override
    public void setH(float h) {
        this.heuristic = h;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void makeGoal() {
        isGoal = true;
    }

    @Override
    public List<INode> getNeighbors() {
        return neighbors;
    }

    @Override
    public INode getCameFromNode() {
        return cameFromNode;
    }

    @Override
    public void setCameFrom(INode node) {
        cameFromNode = node;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " g:" + getG() + " h:" + getH() + " f:" + getF();
    }

}
