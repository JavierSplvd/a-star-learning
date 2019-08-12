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
        INode startingNode = grid.getStartingNode();
        // Then
        assertEquals(startingNode.getX(), 0);
        assertEquals(startingNode.getY(), 0);
    }

}