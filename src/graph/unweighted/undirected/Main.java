package graph.unweighted.undirected;

import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Graph g = new Graph(nums);
        g.addEdge(4, 5);
        g.addEdge(1, 5);
        g.addEdge(1, 4);
        g.addEdge(1, 6);
        g.addEdge(3, 4);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 2);
        g.visualize();
        List<Integer> result = g.findMinDist(2, 5);
        for(Integer i : result){
            System.out.print(i);
        }
    }
}
