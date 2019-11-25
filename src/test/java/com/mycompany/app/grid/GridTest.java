package com.mycompany.app.grid;

import com.mycompany.app.grid.SpainGrid;
import com.mycompany.app.grid.INode;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class GridTest extends TestCase {

    @Test
    public void testGetStartingNode() {
        // Given
        IGrid grid = new SpainGrid();
        // When
        INode startingNode = grid.getStartingNode();
        // Then
        assertEquals(startingNode.getX(), 0);
        assertEquals(startingNode.getY(), 0);
    }

}