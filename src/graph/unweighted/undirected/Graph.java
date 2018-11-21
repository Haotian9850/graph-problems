package graph.unweighted.undirected;

import java.util.*;

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

    /*custom getChildren method*/
    private Set<Node> getChildren(int i){
        Set<Node> result = new HashSet();
        for(Node n : this.nodes){
            if(n.val == i){
                for(Node child : n.children){
                    result.add(child);
                }
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


    /*find shortest number of edges connecting two nodes, i -> j
    * TODO: make this work!*/
    public List<Integer> findMinDist(int i, int j){
        //classic BFS approach, queue of routes
        LinkedList<List<Integer>> queue = new LinkedList<>();
        List<Integer> currPath = new ArrayList<>();
        currPath.add(i);
        queue.add(currPath);
        while(!queue.isEmpty()){
            List<Integer> path = queue.remove();
            Node lastNode = get(this.nodes, path.get(path.size() - 1));

            //return condition
            if(lastNode.val == j){
                return path;    //assume a path will always exist
            }

            Set<Node> children = getChildren(lastNode.val);
            for(Node n : children){
                currPath.add(n.val);
                queue.add(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);
            }
        }
        return null;
    }

}
