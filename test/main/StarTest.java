package main;

import grid.Node;
import junit.framework.TestCase;

import static org.junit.Assert.*;

public class StarTest extends TestCase {

    private Star star;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testGetNodeWithLowestFit(){
        // Given
        star = new Star();
        // When
        Node startNode = star.getNodeWithLowestFit();
        // Then
        float fitExpected = 0;
        assertEquals(startNode.getF(), fitExpected);
        assertEquals(startNode.getX(), 0);
        assertEquals(startNode.getY(), 0);
    }

    public void test(){
        // Given
        star = new Star();
        // When
        Node startNode = star.getNodeWithLowestFit();
        // Then

    }

}