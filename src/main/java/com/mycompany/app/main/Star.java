package com.mycompany.app.main;

import com.mycompany.app.grid.Grid;
import com.mycompany.app.grid.INode;

import java.util.ArrayList;
import java.util.List;

public class Star {
    private Grid grid;

    private List<INode> openSet = new ArrayList<>();
    private List<INode> closedSet = new ArrayList<>();


    public Star(){
        grid = new Grid();
        openSet.add(grid.getStartingNode());
    }

    public String run() {
        while (!openSet.isEmpty()){
            INode current = getNodeWithLowestFit();
            if (current == grid.getGoal()){
                return pathFrom(current);
            }
            openSet.remove(current);
            closedSet.add(current);
            for(INode neighbor: current.getNeighbors()){
                if(closedSet.contains(neighbor)){
                    continue;
                }
                float h = grid.straightLineDistanceFrom(current, neighbor);
                float tentativeGScore = current.getG() + h;
                if(!openSet.contains(neighbor)){
                    openSet.add(neighbor);
                }
                if(tentativeGScore < neighbor.getG()){
                    neighbor.setCameFrom(current);
                    neighbor.setG(tentativeGScore);
                    neighbor.setH(grid.straightLineDistanceFrom(grid.getGoal(), neighbor));
                }
            }
        }
        return pathFrom(grid.getGoal());
    }

    private String pathFrom(INode current) {
        String path = "";

        while(current.getCameFromNode() != null){
            path = path + current.toString() + " ";
            current = current.getCameFromNode();
        }
        path = path + grid.getStartingNode().toString();
        return path;
    }


    public INode getNodeWithLowestFit() {
        INode tentativeNode = openSet.get(0);
        float lowestFit = openSet.get(0).getF();
        for (INode n : openSet){
            if(n.getF() < lowestFit){
                tentativeNode = n;
            }
        }
        return tentativeNode;
    }

    Grid getGrid() {
        return grid;
    }

    public List<INode> getOpenSet() {
        return openSet;
    }
}
