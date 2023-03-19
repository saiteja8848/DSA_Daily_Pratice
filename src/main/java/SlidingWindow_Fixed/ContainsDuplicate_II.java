package SlidingWindow_Fixed;

import java.util.HashSet;
import java.util.LinkedHashSet;

//https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicate_II {

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		// bruteForce: O(n*min(n,k))
//	         for(int i=0;i<nums.length;i++){

//	             for(int j=i+1;j<nums.length&&j<=i+k;j++){
//	                 if(nums[i]==nums[j])
//	                     return true;
//	             }
//	         }
//	         return false;

		// O(n)
		HashSet<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
			if (set.size() > k)
				set.remove(nums[i - k]);
		}
		return false;
	}

	public static void main(String[] args) {

	}

}
