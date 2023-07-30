package BinarySearch;

public class SearchInASortedRotatedMatrix {

	public int search(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (target == nums[mid])
				return mid;

			// step 1: we need find our element is left sorted or right sorted
			// example: 8, 9 , 10, 1, 2,3, 4 , here 1 is left sorted where as 10 is right
			// sorted // here 1 is left sorted

			if (nums[low] <= nums[mid]) {
				// step 2: now we need check where target lies in the range of left sorted
				if (nums[low] <= target && target <= nums[mid]) {
					high = mid - 1;
				} else
					low = mid + 1;
			} else { // else right sorted

				if (nums[mid] <= target && target <= nums[high]) {
					low = mid + 1;
				} else
					high = mid - 1;

			}

		}

		return -1;

	}

	// Duplicates allowed
	public boolean search22(int[] nums, int target) {
		int i = 0, n = nums.length, j = n - 1, mid;
		while (i <= j) {
			mid = (i + j) / 2;
			if (nums[mid] == target || nums[i] == target || nums[j] == target)
				return true;
			if (nums[i] == nums[j]) {
				i++;
				j--;
				continue;
			}

			if (nums[i] <= nums[mid]) {
				if (nums[i] <= target) {
					if (nums[mid] < target)
						i = mid + 1;
					else
						j = mid - 1;
				} else {
					i = mid + 1;
				}
			} else {
				if (nums[i] > target) {
					if (nums[mid] < target)
						i = mid + 1;
					else
						j = mid - 1;
				} else
					j = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
