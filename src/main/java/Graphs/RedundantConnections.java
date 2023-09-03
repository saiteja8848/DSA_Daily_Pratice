package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

class UnionFind {
    int[] parent, size;
    public UnionFind(int n) {
        parent = new int[n]; size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; size[i] = 1;
        }
    }
    public int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]); // Path compression
    }
    public boolean union(int u, int v) {
        int pu = find(u), 
        pv = find(v);
        if (pu == pv) 
            return false; // Return False if u and v are already union
        if (size[pu] > size[pv]) { // Union by larger size
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }
        return true;
    }
}

public class RedundantConnections {
      public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; 
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            if (!uf.union(e[0]-1, e[1]-1)) 
                 return new int[]{e[0], e[1]};
        }
        return new int[]{};
    }
}



// Cycle detection in a undirected graph

class SolutionDFS_CYCLCE {
    public int[] findRedundantConnection(int[][] edges) {
       if(edges.length == 0)return new int[]{0,0};
        // LETS CREATE GRAPH
        int n = edges.length+1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        for(int i = 0; i<n; i++ ){
            adj.add(new ArrayList<>());
        }
        boolean vis[] = new boolean[n];
        int ans []= new int[2];
        for(int c[]: edges){
            Arrays.fill(vis, false);
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(c[0]);
            if(dfs(c[0],-1,vis, adj)){
                return c; 
            }
        }
        return ans; 
    }
   public boolean dfs(int node,int parent, boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        for(int adjacent:adj.get(node)){
            if(!visited[adjacent]){
                if(dfs(adjacent,node,visited,adj))
                  return true;
            }else if(parent!=adjacent)
               return true;
        }
        return false;
    }
}
