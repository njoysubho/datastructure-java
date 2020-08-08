package org.example.graph.undirected;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
public class UndirectedGraph{
    private int vertices;
    private int edges;
    Map<Integer,List<Integer>> adjacencyList;
    boolean[] marked;
    int[] color;
    boolean bipartite=true;

    private UndirectedGraph(){

    }

    public UndirectedGraph(int vertices){
        this.vertices = vertices;
        adjacencyList = new HashMap<>(vertices);
        marked = new boolean[vertices];
        color = new int[vertices];
        for(int i=0;i<vertices;i++){
            adjacencyList.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<vertices;i++){
            color[i]=-1;
        }
    }

    public boolean addEdge(int from, int to){
        edges++;
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
        return true;
    }


    private boolean isAdj(int a, int b){
        return adjacencyList.get(a).contains(b);
    }

    public void BFS(int source){
        var start=System.currentTimeMillis();
        var edgeTo = new int[vertices];
        for (int i=0;i<vertices;i++) {
            edgeTo[i] = Integer.MAX_VALUE;
        }
        var queue = new LinkedList<Integer>();
        queue.add(source);
        while (!queue.isEmpty()) {
            var current = queue.remove();
            marked[current]=true;
            for (int i:adjacencyList.get(current)) {
                if (!marked[i]) {
                    edgeTo[i] = current;
                    queue.add(i);
                }
            }
        }
        System.out.println("["+Thread.currentThread().getName()+" ]"+"Vertex="+vertices+" time="+(System.currentTimeMillis()-start)+" ms");
    }

    public void isBipartite(int source){
        var start=System.currentTimeMillis();
        var queue = new LinkedList<Integer>();
        queue.add(source);
        color[source]=0;
        while (!queue.isEmpty()) {
            var current = queue.remove();
            marked[current]=true;
            for (int i:adjacencyList.get(current)) {
                if (!marked[i]) {
                    if(color[i]==color[current]){
                        bipartite=false;
                        System.out.println("Graph is not bipartite");
                    }else{
                        color[i]=color[current]==1?0:1;
                    }
                    queue.add(i);
                }
            }
        }
        System.out.println("["+Thread.currentThread().getName()+" ]"+"Vertex="+vertices+" time="+(System.currentTimeMillis()-start)+" ms");
    }

    private void dfs( int v) {
        var marked = new boolean[vertices];
        marked[v] = true;
        for (int i:adjacencyList.get(v)) {
            if (!marked[i]) {
                dfs(i);
            }
        }
    }

    private void resetAllColor(Set<Vertex> vertices){
        for (Vertex v : vertices) {
            v.setColor("white");
        }
    }

    public boolean isTwoColor(){
        for(int i=0;i<vertices;i++){
            if(!marked[i]){
                isBipartite(i);
            }
        }
      return bipartite;
    }
}

@Data
class Vertex{
    private Vertex parent;
    private String name;
    private int pos;
    private String color = "white";

    public Vertex at(int pos){
        this.pos = pos;
        return this;
    }
}

@Data
@AllArgsConstructor
class Edge{
    private Vertex from;
    private Vertex to;
    private int weight;

    public int getFromEdgePos(){
        return from.getPos();
    }

    public int getToEdgePos(){
        return to.getPos();
    }
}
