package graph.adjacencyList.weighted.undirected;

public class Edge {

    int nodeA;
    int nodeB;
    int weight;

    public Edge(){
        //default constructor
        this.nodeA = -1;
        this.nodeB = -1;
        this.weight = -1;
    }

    public Edge(int node1, int node2, int weight){
        this.nodeA = node1;
        this.nodeB = node2;
        this.weight = weight;
    }

}
