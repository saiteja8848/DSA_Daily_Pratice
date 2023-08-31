package Graphs;

public class DisjointSet {
    	int find(int A[],int X){
        return A[X]==X ? X : find(A,A[X]);
	}
	void unionSet(int A[],int X,int Z){
       int xParent = find(A,X);
       int yParent = find(A,Z);
       A[xParent]=yParent;
	}
}
