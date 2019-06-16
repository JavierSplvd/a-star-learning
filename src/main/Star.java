package main;

import grid.Grid;
import grid.Node;

import java.util.ArrayList;
import java.util.Stack;

public class Star {
    private Grid oriGrid;


    public Star() {
        oriGrid = new Grid();
        // f: fit parameter
        // q: movement cost to move from the starting position to that node
        // h: estimated movement cost to move from this node to the goal

        // Init open list
        ArrayList<Node> openList = oriGrid.dumpOpenList();
        // Init closed list
        Stack closeList = new Stack();

        // While open list is not empty
        // Find the node with the least f on the open list
        // call it q
        Node q = oriGrid.getStartingNode();
        // pop q off the open list
        openList.remove(q);
        // generate successors for q
        oriGrid.findSuccessorsFor(q);
        // for each successor
        // if successor is the goal stop

        // calc heuristics for the successor

        // if a node with the same position as successor is in the open list
        // and has a lower f than successor, skip it

        // if a node with the same position as successor is in the closed list
        // and has a lower f than successor, skip it
        // otherwise, add it to the open list

        // end loop

        // push q on the closed list

    }


    public Node getNodeWithLowestFit() {
        return oriGrid.getStartingNode();
    }
}
