package graph.weighted.directed;

public class Main {

    /*
    * main testing class
    * */

    public static void main(String[] args){
        Graph g = new Graph(7);

        g.addEdge(2, 1, 1);
        g.addEdge(2, 0, 3);
        g.addEdge(6, 2, 7);
        g.addEdge(0, 6, 5);
        g.addEdge(3, 2, 8);
        g.addEdge(3, 6, 29);
        g.addEdge(6, 5, 569);
        g.addEdge(3, 4, 11);
        g.addEdge(4, 5, 47);

        g.visualize();
    }
}
