package graph.weighted.undirected;

public class Edge {

    int node1;
    int node2;
    int weight;

    public Edge(){
        //default constructor
        this.node1 = -1;
        this.node2 = -1;
        this.weight = -1;
    }

    public Edge(int node1, int node2, int weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

}
