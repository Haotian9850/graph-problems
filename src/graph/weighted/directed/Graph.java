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
    List<LinkedList<Integer>> list;

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

    

}
