package org.example.graph.undirected;

public class Main{
    public static void main(String[] args){

        UndirectedGraph graph = new UndirectedGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        System.out.println(graph.isTwoColor());
    }

}
