package graph.adjacencyList.unweighted.undirected;

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
            this.list.add(new LinkedList<>());
        }
    }

    public void addEdge(int i, int j){
        //check input
        if(i < 0 || i >= this.numNodes || j < 0 || j >= this.numNodes){
            throw new IndexOutOfBoundsException("Malformed input!");
        }
        //add two edges
        this.list.get(i).offerLast(j);
        this.list.get(j).offerLast(i);
    }

    public void visualize(){
        for(int i = 0; i < this.numNodes; ++ i){
            System.out.print("node " + i + ":");
            for(Integer child : this.list.get(i)){
                System.out.print(" " + child);
            }
            System.out.println();   //new line separator
        }
    }


    /*
    * find min path from node i to node j, i -> j
    * */
    public List<Integer> minPath(int i, int j){
        //check input
        if(i < 0 || i >= this.numNodes || j < 0 || j >= this.numNodes){
            throw new IndexOutOfBoundsException("Malformed input!");
        }
        //BFS approach
        LinkedList<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        path.add(i);
        queue.add(path);
        while(!queue.isEmpty()){
            List<Integer> currPath = queue.remove();
            int lastNode = currPath.get(currPath.size() - 1);
            if(lastNode == j){
                result = new ArrayList<>(currPath);
                return result;
            }
            for(Integer child : this.list.get(lastNode)){
                currPath.add(child);
                queue.add(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);
            }
        }
        return result;
    }


}
