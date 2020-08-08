package org.example.graph.directed;

import java.util.Arrays;
import java.util.List;

public class DijkstraSP{

    public int shortestPath(DirectedWeightedGraph graph, int source,int target){

        int[] dist = new int[graph.getVertices()];
        boolean[] visited = new boolean[graph.getVertices()];
        initialize(dist);
        dist[source] = 0;

        for (int i = 0; i < graph.getVertices() - 1; i++) {
            int current = getNextMinimum(dist, visited);
            visited[current] = true;
            List<Edge> neighbours = graph.getAdjacentOf(current);
            for (Edge w : neighbours) {
                if (dist[w.getTo()] > dist[current] + w.getWeight()) {
                    dist[w.getTo()] = dist[current] + w.getWeight();
                }
            }
        }
        return dist[target];
    }

    private int getNextMinimum(int[] dist, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void initialize(int[] dist){
        Arrays.fill(dist, Integer.MAX_VALUE);
    }
}
