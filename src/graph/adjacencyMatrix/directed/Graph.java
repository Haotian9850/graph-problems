package graph.adjacencyMatrix.directed;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    public int numNode;
    public int[][] matrix;  //adjacency matrix representation

    public Graph(){
        //emtpy constructor
    }

    public Graph(int numNode){
        this.numNode = numNode;
        this.matrix = new int[numNode][numNode];
        for(int[] row : this.matrix){
            Arrays.fill(row, 0);
        }
    }

    public void addEdge(int src, int dest, int weight){
        this.matrix[src][dest] = weight;
    }


    /*Ford-Fulkerson Algorithm*/

    /*BFS: returns yet another path from source to sink, stored in lastNodeVisited*/
    private boolean BFS(int source, int sink, int[] lastNodeVisited){
        boolean[] visited = new boolean[this.numNode];
        Arrays.fill(visited, false);
        visited[source] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        lastNodeVisited[source] = -1;

        while(!queue.isEmpty()){
            int node = queue.remove();
            for(int i = 0; i < this.numNode; ++ i){
                if(!visited[i] && this.matrix[node][i] != 0){
                    queue.add(i);
                    lastNodeVisited[i] = node;
                    visited[i] = true;
                }
            }
        }

        if(visited[sink]){
            return true;
        }
        return false;
    }

    private int[][] creatResidual(){
        int[][] result = new int[this.numNode][this.numNode];
        for(int i = 0; i < this.numNode; ++ i){
            for(int j = 0; j < this.numNode; ++ j){
                result[i][j] = this.matrix[i][j];
            }
        }
        return result;
    }

    public int maxFlowFordFulkerson(int source, int sink){
        int[][] residualGraph = creatResidual();
        int result = 0;
        int[] lastNodeVisited = new int[this.numNode];

        //impl
        while(BFS(source, sink, lastNodeVisited)){
            int temp = Integer.MAX_VALUE;
            //backtrack in lastNodeVisited; create residual graph
            for(int i = sink; i != source; i = lastNodeVisited[i]){
                int lastNode = lastNodeVisited[i];
                temp = Math.min(temp, residualGraph[lastNode][i]);
                residualGraph[lastNode][i] -= temp;
                residualGraph[i][lastNode] += temp;
            }
            result += temp;
        }
        return result;
    }


    /*TODO: implement Edmunds-Karp Algorithm*/


}
