package TwoPointers;


/**
 * 
 * 
 * @author saiteja
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 */

public class TwoSum_II {

	public int[] twoSum(int[] numbers, int target) {

		int low = 0, high = numbers.length - 1;

		while (low < high) {

			int sum = numbers[low] + numbers[high];

			if (sum > target)
				high--;
			else if (sum < target)
				low++;
			else
				return new int[] { low + 1, high + 1 }; // sum==target

		}

		return new int[2];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
