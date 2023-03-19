package SlidingWindow_Variable;

import java.util.HashSet;

/**
 * 
 * @author saiteja 
 * ProblemLink :https://leetcode.com/problems/longest-substring-without-repeating-characters
 * Tc: O(n) SC : O(1)
 */

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {

		HashSet<Character> set = new HashSet<>();
		int left = 0;
		int ans = 0;
		for (int right = 0; right < s.length(); right++) {
			while (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
	}
}
