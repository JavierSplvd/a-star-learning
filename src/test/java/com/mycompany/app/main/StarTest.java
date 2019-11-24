package com.mycompany.app.main;

import com.mycompany.app.grid.INode;
import com.mycompany.app.main.Star;
import junit.framework.TestCase;

import java.util.List;

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
        INode startNode = star.getNodeWithLowestFit();
        // Then
        float fitExpected = 0;
        assertEquals(startNode.getF(), fitExpected);
        assertEquals(startNode.getG(), 0f);
        assertEquals(startNode.getX(), 0);
        assertEquals(startNode.getY(), 0);
    }

    public void testTheFirstNodeKnownIsTheStart(){
        // Given
        star = new Star();
        INode startNode = star.getNodeWithLowestFit();
        // When
        List<INode> openList= star.getOpenSet();
        // Then
        assertEquals(startNode, openList.get(0));
    }

    public void test(){
        // Given
        star = new Star();
        // When
        System.out.println(star.run());
        // Then
    }

}