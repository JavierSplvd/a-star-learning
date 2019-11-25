package com.mycompany.app.grid;

import java.util.List;

public interface INode {

    float getTotalCost();
    float getAccumulatedCost();
    float getCostToGoal();

    void setAccumulatedCost(float g);
    void setCostToGoal(float h);

    int getX();
    int getY();

    void makeStarting();

    void makeGoal();

    List<INode> getNeighbors();
    void setNeighbors(List<INode> neighbors);

    INode getCameFromNode();
    void cameFrom(INode node);

    String getName();
}
