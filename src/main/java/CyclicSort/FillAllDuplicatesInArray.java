package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FillAllDuplicatesInArray {
	
	public List<Integer> findDuplicates(int[] nums) {

		int i = 0;
		while (i < nums.length) {
			int correct = nums[i] - 1;
			if (nums[i] != nums[correct]) {
				int temp = nums[i];
				nums[i] = nums[correct];
				nums[correct] = temp;
			} else
				i++;
		}
		List<Integer> repeated = new ArrayList<>();
		// Checking for the missing item in the soted array "nums"
		for (int z = 0; z < nums.length; z++) {
			if (nums[z] != z + 1) {
				repeated.add(nums[z]);
			}
		}

		return repeated;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
