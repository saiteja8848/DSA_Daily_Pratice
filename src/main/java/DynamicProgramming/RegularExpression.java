package DynamicProgramming;

/*
 * 
 * Problem Link : https://leetcode.com/problems/regular-expression-matching/
 * 
 * */


public class RegularExpression {
	
	

	  /*
	    
	    main idea:
	    
	        using two pointers i, j go through each character of s and p
	        
	        for wildcard * the two options are not use it or use it one or more times
	        
	        s=aa  p=a*                  a*
	                                /        \
	                             a(use)   ""(not use)
	                            /     \
	                        aa(use)    a(not use)
	                        
	        
	        
	        if we decide not to use it, 
	            
	            we need to move j fwd twice (so that we skip *)
	            i remains the same

	        each time we use it,
	            move i fwd (meaning we matched one char of s)
	            j remains the same
	    
	    
	    recursive approach
	    
	        if i and j reach the end of s and p, means s matches the pattern
	    
	        if only j reaches the end, means s doesn't match the pattern
	        
	        if chars of s and p at index i and j are equal or if char at p is . we can move i and j fwd
	        
	        if char after p at j + 1 is *
	            
	            recurse without current char
	            recurse using current char       << check if chars at i, j are equal
	        
	        otherwise, we can recurse moving both i and j fwd
	        
	    --
	    
	    improve time complexity using DP Top/Down Memoization
	    
	    dp cache is a bidimensional array of size i + 1, j + 1
	    
	    if cache has the answer for a given i, j, return from there, otherwise, compute and update cache
	    */


	 
	    public boolean isMatch(String s, String p) {
	        return isMatch(s, p, 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
	    }
	    
	    private boolean isMatch(String s, String p, int i, int j, Boolean[][] dp){
	        if(i >= s.length() && j >= p.length()){
	            return true;
	        }

	        if(j >= p.length()){
	            return false;
	        }
	        
	        // if(dp[i][j] != null){
	        //     return dp[i][j];
	        // }
	    
	        boolean matchCondition = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
	        boolean result;
	        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
	            result = isMatch(s, p, i, j + 2, dp) ||  matchCondition && isMatch(s, p, i + 1, j, dp);        
	        } else {
	            result = matchCondition==true ? isMatch(s,p,i+1,j+1,dp) : false;
	        }
	        
	        return result;
	    }
	public static void main(String[] args) {
	}

}
