package com.teja.leetcode.Arrays;

import java.util.Arrays;

/*
 * 
 * 
 * 
 * Leetcode :https://leetcode.com/problems/wiggle-sort-ii/description/
 * 
 * 
 * //sort and swap, so maintain temp arra
        //example: 
        /*
            [1,3,2,2,3,1]
                 
                 midPoint =2     
                 lastPoint=5
             
             0 1 2 3 4 5
            [1,1,2,2,3,3]
            
            Now swap
             [2,3]
             [2,3,1,3]
             [2,3,1,3,1,3]
           O(n)sc , O(nlogn) 
 * 
 * 
 * 
 * */




public class WiggleSort_II {
	
	 public void wiggleSort(int[] nums) {
	        if(nums.length==0)
	            return;
	      
	        Arrays.sort(nums);
	        int[] copy=Arrays.copyOf(nums,nums.length);
	      
	        int len=nums.length;
	        int midPoint= (len%2==0 ? len/2:(len/2) + 1)-1; 
	        int lastPoint = len-1;
	        
	        for(int i=0;i<len;i++){
	            nums[i] = i%2==0 ? copy[midPoint--] : copy[lastPoint--];
	        }
	        
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
