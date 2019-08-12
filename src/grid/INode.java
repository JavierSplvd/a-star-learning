package grid;

import java.util.List;

public interface INode {

    float getF();
    float getG();
    float getH();

    void setG(float g);
    void setH(float h);

    int getX();
    int getY();

    void makeStarting();

    void makeGoal();

    List<INode> getNeighbors();
    void setNeighbors(List<INode> neighbors);

    INode getCameFromNode();
    void setCameFrom(INode node);

    String getName();
}
