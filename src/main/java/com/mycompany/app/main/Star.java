package com.mycompany.app.main;

import com.mycompany.app.grid.SpainGrid;
import com.mycompany.app.grid.IGrid;
import com.mycompany.app.grid.INode;

import java.util.ArrayList;
import java.util.List;

public class Star {

    private IGrid grid;

    private List<INode> openSet = new ArrayList<>();
    private List<INode> closedSet = new ArrayList<>();


    public Star(){
        grid = new SpainGrid();
        openSet.add(grid.getStartingNode());
    }

    public String run() {
        while (!openSet.isEmpty()){
            INode currentNode = getNodeWithLowestFit();
            if (currentNode == grid.getGoal()){
                return pathFrom(currentNode);
            }
            openSet.remove(currentNode);
            closedSet.add(currentNode);
            for(INode neighbor: currentNode.getNeighbors()){
                if(closedSet.contains(neighbor)){
                    continue;
                }
                float distanceToNeighbor = grid.straightLineDistanceFrom(currentNode, neighbor);
                float tentativeAccumulatedScore = currentNode.getAccumulatedCost() + distanceToNeighbor;
                if(!openSet.contains(neighbor)){
                    openSet.add(neighbor);
                }
                if(tentativeAccumulatedScore < neighbor.getAccumulatedCost()){
                    neighbor.cameFrom(currentNode);
                    neighbor.setAccumulatedCost(tentativeAccumulatedScore);
                    neighbor.setCostToGoal(grid.straightLineDistanceFrom(grid.getGoal(), neighbor));
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
        float lowestFit = openSet.get(0).getTotalCost();
        for (INode node : openSet){
            if(node.getTotalCost() < lowestFit){
                tentativeNode = node;
            }
        }
        return tentativeNode;
    }

    IGrid getGrid() {
        return grid;
    }

    public List<INode> getOpenSet() {
        return openSet;
    }
}
