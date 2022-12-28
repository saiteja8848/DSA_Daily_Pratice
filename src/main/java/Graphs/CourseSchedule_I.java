package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Time and Space is O(V+E)
//https://youtu.be/hGscdp38JKM

public class CourseSchedule_I {
	
	 HashMap<Integer, Set<Integer>> adj = new HashMap<>();
	    
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	         
	        int[] visited = new int[numCourses];
	        Arrays.fill(visited,0);
	        for (int i = 0; i < numCourses; i++) {
	            adj.put(i, new HashSet());
	        }
	        
	        for (int i = 0; i < prerequisites.length; i++) {
	            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
	        }
	        
	        for (int i = 0; i < numCourses; i++) {
	            if (visited[i]==0){
	                boolean hasCycle = dfsDetectCycle(i,visited);
	                if(hasCycle)
	                    return false; 
	            }
	        }
	        return true;
	    }
	    
	    private boolean dfsDetectCycle(int n,int[] visited) {
	      
	       if(visited[n]==2)
	           return true;
	    
	        visited[n]=2;
	        for (int e: adj.get(n)) {
	            if (visited[e]!=1) {
	                boolean hasCycle = dfsDetectCycle(e,visited);
	                if (hasCycle) return true;
	            }
	        }
	        
	        visited[n]=1;
	        return false;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
