package graph.weighted.undirected;

import java.util.ArrayList;
import java.util.Comparator;
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

    public void addEdge(int node1, int node2, int weight){
        //check input
        if(node1 < 0 || node1 >= this.numNodes || node2 < 0 || node2 >= this.numNodes || weight < 0){
            throw new IndexOutOfBoundsException("Malformed input!");
        }
        //newEdge
        Edge newEdge = new Edge(node1, node2, weight);
        this.list.get(node1).add(newEdge);
        this.list.get(node2).add(newEdge);
    }

    public int getNumNeighbors(int node){
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
                System.out.println("    " + "(" + e.node1 + " -- " + e.node2 + ") with weight " + e.weight);
            }
            System.out.println();   //new line separator
        }
    }

    /*
    * Prim's algorithm implementation
    *   finds a minimum spanning tree of a given graph
    *   Runtime: O(E log V + V log V)
    * */

    public static class QueueNode {
        int vertex;
        int key;

        public QueueNode(){
            //default constructor
            this.key = -1;
            this.vertex = -1;
        }

        class QueueNodeComparator implements Comparator<QueueNode>{
            @Override
            public int compare(QueueNode queueNode, QueueNode t1) {
                return queueNode.key - t1.key;
            }
        }
    }

    public List<Edge> MSTPrims(){
        //return a list of edges that is the minimum spanning tree
        //BFS approach

    }

}
