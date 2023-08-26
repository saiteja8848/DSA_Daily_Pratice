package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		int maxLength = 0;
		HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
		for (int n : nums) {
			// Step1 : check whether current n is not falling in between sequence
			// we always have to start from the start of sequence

			if (!set.contains(n - 1)) {
				int currentNum = n;
				int count = 1;
				while (set.contains(currentNum + 1)) {
					currentNum += 1;
					count++;
				}
				maxLength = Math.max(count, maxLength);
			}
		}
		return maxLength;
	}
}
