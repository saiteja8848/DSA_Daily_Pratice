package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class GraphDFS {



}




class Solution {
    // Function to return a list containing the DFS traversal of the graph.
 
    void doDepthFirstTraversal(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList,ArrayList<Integer> dft){
          visited[node]=true; // done visiting
          dft.add(node);
          for(int adjacentNode:adjacencyList.get(node)){
                if(!visited[adjacentNode])
                    doDepthFirstTraversal(adjacentNode,visited,adjacencyList,dft);
          }
    }
    
    
    void doDfsIterative(int startNode, boolean[]visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dft){
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(startNode);
        while(!stack.isEmpty()){
           int node = stack.pop();
           if(!visited[node]){
                visited[node] =true;
                dft.add(node);
           }
           for(int adjacentNode:adj.get(node)){
                if(!visited[adjacentNode])
                    stack.push(adjacentNode);
           }
            
        }
    }
    
 

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> dft = new ArrayList<>();
        for(int i=0;i<V;i++){
           if(!visited[i])
              doDepthFirstTraversal(i,visited,adj,dft);
        }
        return dft;
    }
    
    
    
}