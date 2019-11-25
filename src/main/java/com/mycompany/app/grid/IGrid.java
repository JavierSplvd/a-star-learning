package com.mycompany.app.grid;

public interface IGrid {
    
    public INode getStartingNode();
    public INode[] findSuccesorFor(INode q);
    public INode getGoal();
    public float straightLineDistanceFrom(INode current, INode neighbor);

}