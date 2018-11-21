package graph.unweighted.undirected;

import java.util.HashSet;
import java.util.Set;

public class Node {

    /*
    * adjacency list implementation
    * */

    boolean visited = false;
    int val = -1;
    Set<Node> children = new HashSet<>();

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
        result.append(flag + "; ");
        result.append(" children: " + visualizeChildren());
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

    public String visualizeChildren(){
        StringBuilder result = new StringBuilder();
        for(Node n : this.children){
            result.append(n.val + ", ");
        }
        String resultStr = result.toString();
        resultStr = resultStr.substring(0, resultStr.length() - 2);
        return resultStr;
    }

}
