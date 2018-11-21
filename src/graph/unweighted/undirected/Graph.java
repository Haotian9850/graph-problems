package graph.unweighted.undirected;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    /*
    * Wrapper class of Node: graph representation
    * */

    Set<Node> nodes = new HashSet<>();

    public Graph(){
        //default constructor
    }

    public Graph(int[] nums){
        for(Integer i : nums){
            Node newNode = new Node(i);
            this.nodes.add(newNode);
        }
    }

    public void addEdge(int i, int j) throws NoSuchFieldException {
        if(!contains(this.nodes, i) || !contains(this.nodes, j)){
            throw new NoSuchFieldException("Malformed input!");
        }
        get(this.nodes, i).children.add(new Node(j));
        get(this.nodes, j).children.add(new Node(i));   //undirected graph
    }

    /*custom contains method*/
    private static boolean contains(Set<Node> set, int n){
        for(Node node : set){
            if(node.val == n){
                return true;
            }
        }
        return false;
    }

    /*custom get method*/
    private static Node get(Set<Node> set, int i){
        Node result = new Node();
        for(Node n : set){
            if(n.val == i){
                result = n;
            }
        }
        return result;
    }

    public void visualize(){
        for(Node n : this.nodes){
            System.out.println(n.toString());
        }
        System.out.println();   //new line separator
    }



}
