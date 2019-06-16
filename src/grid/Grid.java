package grid;

import java.util.ArrayList;

public class Grid {
    private ArrayList<Node> list;
    private Node start;
    private Node goal;

    public Grid() {
        list = new ArrayList<>(9);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.add(new Node(i, j));
            }
        }
        setAsStart();
        setAsGoal();
    }

    private void setAsStart() {
        Node temp = list.get(0);
        start = temp;
        temp.makeStarting();
    }

    private void setAsGoal() {
        Node temp = list.get(2+2);
        goal = temp;
        temp.makeGoal();
    }

    public Node getStartingNode(){
        return start;
    }

    public ArrayList<Node> dumpOpenList() {
        return (ArrayList<Node>) list.clone();
    }

    public Node[] findSuccessorsFor(Node q) {
        return new Node[0];
    }


}
