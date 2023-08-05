package BinarySearch;

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int k) {
		// Search space : max(nums) to sum(nums)
		int low = 0, high = 0;
		for (int i : nums) {
			if (i > low)
				low = i;
			high += i;
		}
		int ans = low;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int n = noOfSubarraysWithMaxSumAsMid(nums, mid);

			if (n > k) // this means we have taken a very low value of mid, as we are getting more
						// subarrays than required
			{
				low = mid + 1;
			} else // this means mid is are possible answer, but still we'll try to minimize
					// (ooptimize) it
			{
				ans = mid;
				// try to find a better ans i.e., minimize the answer
				high = mid - 1;
			}
		}
		return ans;
	}

	public int noOfSubarraysWithMaxSumAsMid(int[] nums, int mid) {
		int sum = 0;
		int cnt = 1;

		for (int i = 0; i < nums.length; i++) {
			if (sum + nums[i] > mid) {
				sum = nums[i];
				cnt++;
			} else {
				sum += nums[i];
			}
		}
		return cnt;
	}
}
