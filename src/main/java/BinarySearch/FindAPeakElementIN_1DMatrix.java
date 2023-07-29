package BinarySearch;

public class FindAPeakElementIN_1DMatrix {

	public int findPeakElement1(int[] nums) {
		int len = nums.length;
		if (len == 1)
			return 0;

		// if the first element is the peak element - then it is greater the its next
		// element same for the last element
		if (nums[0] > nums[1])
			return 0;

		if (nums[len - 1] > nums[len - 2])
			return len - 1;

		for (int i = 1; i <= len - 2; i++) {

			if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
				return i;
			}
		}

		return 0;
	}

	public int findPeakElement2(int[] nums) {
		int len = nums.length;
		if (len == 1 || nums[0] > nums[1])
			return 0;
		if (nums[len - 1] > nums[len - 2])
			return len - 1;

		int low = 1, high = len - 2;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return mid;
			if (nums[mid] < nums[mid + 1])
				low = mid + 1;
			else
				high = mid - 1;

		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
