package SlidingWindow_Variable;


/**
 * 
 * @author saiteja 
 * ProblemLink :https://leetcode.com/problems/grumpy-bookstore-owner
 * Tc: O(n) SC : O(1)
 */


public class GrumpyBookStoreOwner {
    
	 public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
	        int existingSatisified =0;
	        int currChange=0;
	        int maxChange=0;
	        
	        for(int i=0;i<customers.length;i++){
	            //0 - awake, he received the customers
	            if(grumpy[i]==0)
	                existingSatisified+=customers[i];
	            //1- sleepy, he has n't received the customers with good manner
	            if(grumpy[i]==1)
	                currChange+=customers[i];
	            
	            //incase we are at the end of the window, means we are in second window, now remove 1st windows
	            // 1st value and that only when he is sleepy, other wise it won't effect to sum since it is 0
	            if(i>=minutes&&grumpy[i-minutes]==1)
	                currChange-=customers[i-minutes];
	                // previous windows 1st element
	                
	            maxChange = Math.max(maxChange,currChange);
	        }
	        
	        return existingSatisified + maxChange;
	        
	        
	    }
	
	public static void main(String[] args) {
		
	}
}
