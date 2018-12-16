package graph.adjacencyList.weighted.directed;

import java.util.ArrayList;
import java.util.Arrays;
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
        if(src < 0 || src >= this.numNodes || dest < 0 || dest >= this.numNodes){
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


    /*
    * @return: a list of integers, each equals to the shortest distance from start node
    * to the node of its index
    * */
    public List<Integer> shortestDistToAllBellmanFord(int start){
        List<Integer> result = new ArrayList<>();
        List<Edge> allEdges = getAllEdges();

        int[] dist = new int[this.numNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;    //init

        for(int i = 1; i <= this.numNodes - 1; ++ i){
            for(Edge e : allEdges){
                int src = e.src;
                int dest = e.dest;
                int weight = e.weight;
                if(dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]){
                    //update
                    dist[dest] = dist[src] + weight;
                }
            }
        }
        for(Integer i : dist){
            result.add(i);
        }

        for(Integer i : result){
            System.out.println(i);
        }

        return result;
    }

    /*returns all edges in a directed and weighted graph*/
    public List<Edge> getAllEdges(){
        List<Edge> result = new ArrayList<>();
        for(LinkedList<Edge> neighbors : this.list){
            for(Edge e : neighbors){
                result.add(e);
            }
        }
        return result;
    }

    /*
     * @return: a list of integers, each equals to the shortest distance from start node
     * to the node of its index
     * */
    public List<Integer> shortestDistToAllFloydWarshall(int start){
        List<Integer> result = new ArrayList();
        //DP mem structure
        int[][] dist = new int[this.numNodes][this.numNodes];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int i = 0; i < this.numNodes; ++ i){
            for(int j = 0; j < this.numNodes; ++ j){
                dist[i][j] = 0;
            }
        }
        List<Edge> allEdges = getAllEdges();
        for(Edge e : allEdges){
            int src = e.src;
            int dest = e.dest;
            int weight = e.weight;
            dist[src][dest] = weight;
        }
        //impl
        for(int i = 0; i < this.numNodes; ++ i){
            for(int j = 0; j < this.numNodes; ++ j){
                for(int k = 0; k < this.numNodes; ++ k){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        //make result
        for(int i = 0; i < this.numNodes; ++ i){
            result.add(dist[start][i]);
        }
        for(Integer i : result){
            System.out.println(i);
        }
        return result;
    }

    /*TODO: Max-flow problem, Ford-Fulkerson Algorithm*/







}
