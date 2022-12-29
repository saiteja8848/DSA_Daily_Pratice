package Arrays;

//https://leetcode.com/problems/first-missing-positive

public class FirstMissingPositive {
	
	 public int firstMissingPositive(int[] nums) {
	        
	      int i = 0;
	    
	             // Cyclic Sort in action - trying to place the elements in their respective index
	            while(i<nums.length){
	                int correct = nums[i]-1;
	                if(nums[i]>0 && nums[i] <=nums.length && nums[i]!=nums[correct]){
	                    int temp = nums[i];
	                    nums[i] = nums[correct];
	                    nums[correct]=temp;  
	                }
	                else
	                    i++;
	             }
	    
	              // Checking for the missing item in the soted array "nums"
	                for(int z =0 ;z<nums.length ; z++){
	                    if(nums[z] != z+1){
	                        return z+1;
	                    }
	                }
	    
	        return nums.length+1;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
