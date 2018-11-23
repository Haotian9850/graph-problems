package graph.unweighted.undirected;

import java.util.List;

public class Main {
    /* main testing class */

    public static void main(String[] args){
        Graph g = new Graph(7);
        g.addEdge(5, 6);
        g.addEdge(5, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 2);
        g.addEdge(1, 2);
        g.addEdge(0, 2);
        g.addEdge(0, 6);
        g.addEdge(2, 6);
        g.addEdge(1, 5);

        g.visualize();

        List<Integer> minPath = g.minPath(2, 6);
        for(Integer i : minPath){
            System.out.println(i);
        }
    }
}
