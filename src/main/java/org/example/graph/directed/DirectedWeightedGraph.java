package org.example.graph.directed;

import lombok.Data;

import java.util.*;
import java.util.stream.IntStream;

@Data
public class DirectedWeightedGraph{
    private int vertices;
    private Set<Edge> edges;
    private HashMap<Integer, ArrayList<Edge>> adjList;
    public DirectedWeightedGraph(int numOfVertices){
        this.vertices = numOfVertices;
        edges = new HashSet<>(this.vertices - 1);
        adjList=new HashMap<>();
        IntStream.range(0,vertices)
                .forEach(index->adjList.put(index,new ArrayList<Edge>()));
    }

    public void addEdge(int from, int to, int weight){
        verifyVertex(from);
        verifyVertex(to);
        var edge = new Edge(from, to, weight);
        edges.add(edge);
        adjList.get(from).add(edge);
    }

    public List<Edge> getAdjacentOf(int vertex){
        return adjList.get(vertex);
    }

    private void verifyVertex(int vertex){
        if (vertex < 0 || vertex >= vertices)
            throw new IllegalArgumentException("Vertex index should be between 0 and" + vertices);
    }
}

@Data
class Edge implements Comparable<Edge>{
    private int from;
    private int to;
    private int weight;

    public Edge(int from, int to){
        this(from, to, -1);
    }

    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other){
        if(weight>other.getWeight()){
            return 1;
        }
        return -1;
    }
}
