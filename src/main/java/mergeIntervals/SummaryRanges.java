package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		int start = 0;
		int end = 0;
		int n = nums.length;
		int i = 0;

		while (i < n) {
			if (i + 1 < n && nums[i + 1] - nums[i] == 1) {
				// Continue building the current range
				end++;
			} else {
				// The current range is complete
				if (start == end) {
					result.add(String.valueOf(nums[end]));
				} else {
					result.add(nums[start] + "->" + nums[end]);
				}

				// Move to the next element
				end++;
				start = end;
			}
			i++;
		}

		return result;
	}
}
