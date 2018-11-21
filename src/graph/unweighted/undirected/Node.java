package graph.unweighted.undirected;

import java.util.HashSet;
import java.util.Set;

public class Node {

    /*
    * adjacency list implementation
    * */

    boolean visited = false;
    int val = -1;
    Set<Integer> children = new HashSet<>();

    public Node(){
        //default constructor
    }

    public Node(int val){
        this.val = val;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("val: " + this.val + ", ");
        String flag = new String();
        if(this.visited){
            flag = "visited";
        }else{
            flag = "unvisited";
        }
        result.append(flag);
        return result.toString();
    }

    @Override
    public boolean equals(Object o){
        //comparison only bases on val
        Node node = (Node)o;
        if(this.val == node.val){
            return true;
        }
        return false;
    }

    public void printChildren(){
        System.out.print("children: ");
        for(Integer n : this.children){
            System.out.print(n + " ");
        }
        System.out.println();   //new line separator
    }

}
