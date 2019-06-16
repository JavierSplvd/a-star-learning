package grid;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class GridTest extends TestCase {

    @Test
    public void testGetStartingNode() {
        // Given
        Grid grid = new Grid();
        // When
        Node startingNode = grid.getStartingNode();
        // Then
        assertEquals(startingNode.getX(), 0);
        assertEquals(startingNode.getY(), 0);
    }

    @Test
    public void testDumpOpenList() {
        // Given
        Grid grid = new Grid();
        // When
        ArrayList<Node> list = grid.dumpOpenList();
        // Then
        assertEquals(list.size(), 9);
    }
}