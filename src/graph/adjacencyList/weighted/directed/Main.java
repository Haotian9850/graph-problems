package graph.adjacencyList.weighted.directed;

public class Main {

    /*
    * main testing class
    * */

    public static void main(String[] args){
        Graph g = new Graph(10);

        g.addEdge(0, 1, 5);
        g.addEdge(1, 2, 20);
        g.addEdge(2, 3, 10);
        g.addEdge(3, 2, -15);
        g.addEdge(2, 4, 75);
        g.addEdge(1, 6, 60);
        g.addEdge(5, 6, 5);
        g.addEdge(6, 7, -50);
        g.addEdge(5, 4, 25);
        g.addEdge(4, 9, 100);
        g.addEdge(5, 8, 50);
        g.addEdge(7, 8, -10);



        g.visualize();

        g.getAllEdges();

        g.shortestDistToAllBellmanFord(0);

        g.shortestDistToAllFloydWarshall(0);
    }
}
