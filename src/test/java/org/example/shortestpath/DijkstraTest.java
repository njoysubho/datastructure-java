package org.example.shortestpath;

import org.example.graph.directed.DijkstraSP;
import org.example.graph.directed.DirectedWeightedGraph;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DijkstraTest{


    @Test
    @DisplayName("Basic test small graph")
    public void testBasicGraph(){
        DirectedWeightedGraph graph = new DirectedWeightedGraph(4);
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,2);
        graph.addEdge(1,3,8);
        graph.addEdge(2,3,3);
        DijkstraSP dijkstraSP = new DijkstraSP();
        assertAll("Shortest path should be 5",
                ()->assertEquals(5,dijkstraSP.shortestPath(graph,0,3)));
    }
}
