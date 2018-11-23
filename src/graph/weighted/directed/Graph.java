package graph.weighted.directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    /*
    * adjacency list implementation of weighted directed graph
    * Edge as separate entity
    * */

    int numNodes;
    List<LinkedList<Edge>> list;

    public Graph(){
        //default constructor
        this.numNodes = -1;
    }

    public Graph(int numNodes){
        this.numNodes = numNodes;
        this.list = new ArrayList<>();
        for(int i = 0; i < this.numNodes; ++ i){
            this.list.add(new LinkedList<>());
        }
    }

    public void addEdge(int src, int dest, int weight){
        //check input
        if(src < 0 || src >= this.numNodes || dest < 0 || dest >= this.numNodes || weight < 0){
            throw new IndexOutOfBoundsException("Malformed input!");
        }
        //newEdge
        Edge newEdge = new Edge(src, dest, weight);
        this.list.get(src).add(newEdge);
    }

    public int getOutdegree(int node){
        if(node < 0 || node >= this.numNodes){
            throw new IndexOutOfBoundsException("Malformed input!");
        }
        return this.list.get(node).size();
    }

    public void visualize(){
        for(int i = 0; i < this.numNodes; ++ i){
            System.out.println("node " + i + ": ");
            LinkedList<Edge> edgeList = this.list.get(i);
            for(Edge e : edgeList){
                System.out.println("    " + "(" + e.src + " -> " + e.dest + ") with weight " + e.weight);
            }
            System.out.println();   //new line separator
        }
    }
}
