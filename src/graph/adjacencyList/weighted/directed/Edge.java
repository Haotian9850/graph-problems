package graph.adjacencyList.weighted.directed;

public class Edge {

    int src;
    int dest;
    int weight;

    public Edge(){
        //default constructor
        this.src = -1;
        this.dest = -1;
        this.weight = -1;
    }

    public Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }



}
