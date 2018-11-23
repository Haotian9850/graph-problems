package graph.unweighted.undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    /* adjacency list implementation
     * generate graph containing nodes [0, this.numNode)
     * implementation
      * */

    int numNodes;
    List<LinkedList<Integer>> list;

    public Graph(){
        //default constructor
        this.numNodes = -1;
    }

    public Graph(int numNodes){
        this.numNodes = numNodes;
        this.list = new ArrayList<>();
        //init
        for(int i = 0; i < this.numNodes; ++ i){
            this.list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j){
        //check input
        if(i < 0 || i >= this.numNodes || j < 0 || j >= this.numNodes){
            throw new IndexOutOfBoundsException("Malformed input!");
        }
        //add two edges
        this.list[i].offerLast(j);
        this.list[j].offerLast(i);
    }

    public void visualize(){
        for(int i = 0; i < this.numNodes; ++ i){
            System.out.print("node " + i + ":");
            for(Integer child : this.list[i]){
                System.out.print(" " + child);
            }
            System.out.println();   //new line separator
        }
    }

}
