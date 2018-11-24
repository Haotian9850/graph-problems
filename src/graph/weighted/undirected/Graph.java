package graph.weighted.undirected;

import java.util.*;

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
                System.out.println("    " + "(" + e.nodeA + " -- " + e.nodeB + ") with weight " + e.weight);
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
        int key;    //dist

        public QueueNode(){
            //default constructor
            this.key = -1;
            this.vertex = -1;
        }

        static class QueueNodeComparator implements Comparator<QueueNode>{
            @Override
            public int compare(QueueNode queueNode, QueueNode t1) {
                return queueNode.key - t1.key;
            }
        }
    }

    public List<int[]> MSTPrims(){
        //return a list of edges that is the minimum spanning tree
        //BFS approach
        List<int[]> result = new ArrayList<>();

        boolean[] inHeap = new boolean[this.numNodes];
        QueueNode[] nodeSet = new QueueNode[this.numNodes];
        int[] parents = new int[this.numNodes]; //in question of this array...

        //init
        Arrays.fill(inHeap, false);
        for(int i = 0; i < this.numNodes; ++ i){
            nodeSet[i] = new QueueNode();
            nodeSet[i].key = Integer.MAX_VALUE;
            nodeSet[i].vertex = i;
            parents[i] = -1;    //?
        }
        inHeap[0] = true;   //start from 0, assuming a MST will always exist

        PriorityQueue<QueueNode> heap = new PriorityQueue<>(this.numNodes, new QueueNode.QueueNodeComparator());
        for(int i = 1; i < this.numNodes; ++ i){
            heap.add(nodeSet[i]);
        }

        while(!heap.isEmpty()){
            QueueNode node = heap.poll();
            inHeap[node.vertex] = true;

            for(Edge e : this.list.get(node.vertex)){
                int neighbor = -1;
                if(e.nodeA != node.vertex){
                    neighbor = e.nodeA;
                }else{
                    neighbor = e.nodeB;
                }
                if(!inHeap[neighbor]){
                    //update key value
                    if(nodeSet[neighbor].key > e.weight){
                        heap.remove(nodeSet[neighbor]);
                        nodeSet[neighbor].key = e.weight;
                        heap.add(nodeSet[neighbor]);
                        parents[neighbor] = node.vertex;
                    }
                }
            }
        }
        //make result
        for(int i = 0; i < this.numNodes; ++ i){
            int[] pair = new int[2];
            pair[0] = parents[i];
            parents[1] = i;
            result.add(pair);
        }
        return result;
    }

}
