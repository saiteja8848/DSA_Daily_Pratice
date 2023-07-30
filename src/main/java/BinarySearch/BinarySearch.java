package BinarySearch;

public class BinarySearch {

	public int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return mid;
			else if (target > nums[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public int recursiveSearch(int[] nums, int low, int high, int target) {
		if (low > high) {
			return -1;
		}

		int mid = low + (high - low) / 2;
		if (nums[mid] == target)
			return mid;

		else if (nums[mid] < target) {
			return recursiveSearch(nums, mid + 1, high, target);
		}

		else {
			return recursiveSearch(nums, low, mid - 1, target);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
