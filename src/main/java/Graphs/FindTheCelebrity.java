package Graphs;


/*
 * 
 * Problem stmt : In a party, a group of people are there, out them 1 celebrity is there
 * so find that celebrity
 * 
 * By Definition of celebrity : celebrity is known to all the people in the party
 * but for celebrity, he doesn't know any one
 * 
 * Problem Link : https://www.lintcode.com/problem/645/description
 * 
 * 
 * Video Link : https://youtu.be/5rkKCrPzD8c
 * 
 * 
 * Logic : 
 * Step 1: Pick a candidate and check with all other persons in linear order is enough
 *   and update if both knowing each other
 *   
 * Step2: check candidate against rules, he should not be knowing anyone 
 *   he is known to all other people in the party
 * if not return -1
 * 
 * 
 * 
 * */


public class FindTheCelebrity {
	
	 boolean knows(int a, int  b) {
		 return false; // some logic, there are using API which checks in 2D Matrix
	 }
	
	 public int findCelebrity(int n) {
	        if (n <= 0) {
	            return -1;
	        }
	        if (n == 1) {
	            return 0;
	        }
	        int candi = 0;
	        for (int i = 1; i < n; ++i) {
	            if (knows(candi, i)) {
	                candi = i;
	            }
	        }
	        // check candi according to the def of celebrity
	        for (int i = 0; i < n; ++i) {
	        	//since we assume candidate as celebrity
	        	//if candidate doesn't know to i - return false
	            if (i != candi && !knows(i, candi)) {
	                return -1;
	            }
	            
	            //if candidate knows the other person return false
	            if (i != candi && knows(candi, i)) {
	                return -1;
	            }
	        }
	        return candi;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
