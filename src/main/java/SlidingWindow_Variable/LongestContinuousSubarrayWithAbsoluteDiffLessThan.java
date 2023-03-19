package SlidingWindow_Variable;

import java.util.TreeMap;

// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

class Solution1 {
	// Solution 2: Use TreeMap
// Use one tree map can easily get the maximum and the minimum at the same time.
// In java, we can use TreeMap to count elements.
// In cpp, it suports multi treeset, that's even better.

// Time O(NogN)
// Space O(N)

	public int longestSubarray(int[] A, int limit) {
		int i = 0, j;
		TreeMap<Integer, Integer> m = new TreeMap<>();
		for (j = 0; j < A.length; j++) {
			m.put(A[j], 1 + m.getOrDefault(A[j], 0));
			if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
				m.put(A[i], m.get(A[i]) - 1);
				if (m.get(A[i]) == 0)
					m.remove(A[i]);
				i++;
			}
		}
		return j - i;
	}
}

public class LongestContinuousSubarrayWithAbsoluteDiffLessThan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
