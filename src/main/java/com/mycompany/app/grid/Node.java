package com.mycompany.app.grid;

import java.util.List;

public class Node implements INode {

    private final String name;
    private int x;
    private int y;

    private float accumulatedCost = Float.MAX_VALUE;
    private float costToGoal = 0;

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
        accumulatedCost = 0;
    }

    @Override
    public float getTotalCost() {
        return accumulatedCost+costToGoal;
    }

    @Override
    public float getAccumulatedCost() {
        return accumulatedCost;
    }

    @Override
    public float getCostToGoal() {
        return costToGoal;
    }

    @Override
    public void setAccumulatedCost(float g) {
        this.accumulatedCost = g;
    }

    @Override
    public void setCostToGoal(float h) {
        this.costToGoal = h;
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
    public void cameFrom(INode node) {
        cameFromNode = node;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " g:" + getAccumulatedCost() + " h:" + getCostToGoal() + " f:" + getTotalCost();
    }

}
