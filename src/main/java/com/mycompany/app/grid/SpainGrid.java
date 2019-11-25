package com.mycompany.app.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpainGrid implements IGrid {
    private List<INode> totalSet = new ArrayList<>(4);
    private INode start;
    private INode goal;

    public SpainGrid() {
        Node madrid = new Node(0, 0, "Madrid");
        Node valencia = new Node(110, 0, "Valencia");
        Node barcelona = new Node(100, 100, "Barcelona");
        Node bilbao = new Node(0, 100, "Bilbao");
        madrid.setNeighbors(new ArrayList<>(Arrays.asList(valencia, bilbao)));
        valencia.setNeighbors(new ArrayList<>(Arrays.asList(madrid, barcelona)));
        bilbao.setNeighbors(new ArrayList<>(Arrays.asList(madrid, barcelona)));
        barcelona.setNeighbors(new ArrayList<>(Arrays.asList(valencia, bilbao)));
        totalSet.add(madrid);
        totalSet.add(valencia);
        totalSet.add(barcelona);
        totalSet.add(bilbao);
        setAsStart(0);
        setAsGoal(2);
        madrid.setH(straightLineDistanceFrom(madrid, goal));
        valencia.setH(straightLineDistanceFrom(valencia, goal));
        bilbao.setH(straightLineDistanceFrom(bilbao, goal));
        barcelona.setH(straightLineDistanceFrom(barcelona, goal));


    }

    private void setAsStart(int indexForStarting) {
        INode temp = totalSet.get(indexForStarting);
        start = temp;
        temp.makeStarting();
    }

    private void setAsGoal(int indexForEnding) {
        INode temp = totalSet.get(indexForEnding);
        goal = temp;
        temp.makeGoal();
    }

    public INode getStartingNode() {
        return start;
    }

    public INode[] findSuccessorsFor(INode q) {
        return new INode[0];
    }

    public INode getGoal() {
        return goal;
    }

    public float straightLineDistanceFrom(INode current, INode neighbor) {
        int diffX = current.getX() - neighbor.getX();
        int diffY = current.getY() - neighbor.getY();
        return diffX * diffX + diffY * diffY;
    }
}
