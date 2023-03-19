package SlidingWindow_Variable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author saiteja 
 * ProblemLink :https://leetcode.com/problems/minimum-window-substring/
 * Tc: O(n) SC : O(1)
 */

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {

		if (s.length() == 0 || t.length() == 0)
			return "";

		Map<Character, Integer> tCount = new HashMap<>();
		Map<Character, Integer> sCount = new HashMap<>();

		// Here maps are used to compare, for eg: substring = BANC and t = "ABC"
		// substring = [B-1,A-1,N-1,C-1] and t = [A-1,B-1,C-1] so t is present in
		// substring

		for (char ch : t.toCharArray())
			tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);

		// expected window size and current
		int expectedWindowSize = tCount.size();
		int currentWindowSize = 0;

		// ans
		int startIndex = 0;
		int endIndex = 0;
		int minLength = -1;

		// windowptrs
		int startPtr = 0;
		int endPtr = 0;

		while (endPtr < s.length()) {
			char ch = s.charAt(endPtr);
			int count = sCount.getOrDefault(ch, 0);
			sCount.put(ch, count + 1);

			if (tCount.containsKey(ch) && tCount.get(ch).intValue() == sCount.get(ch).intValue())
				currentWindowSize++;

			// so if we hit this condition means, we have a substring with us which is
			// covering t
			// now we have to check, can we make it even smaller length -> which is still
			// matching t

			while (startPtr <= endPtr && currentWindowSize == expectedWindowSize) {
				char c = s.charAt(startPtr);
				if (minLength == -1 || endPtr - startPtr + 1 < minLength) {
					minLength = endPtr - startPtr + 1;
					startIndex = startPtr;
					endIndex = endPtr;
				}

				sCount.put(c, sCount.get(c) - 1);

				if (tCount.containsKey(c) && sCount.get(c).intValue() < tCount.get(c).intValue())
					currentWindowSize--;

				startPtr++;
			}

			endPtr++;
		}

		return minLength == -1 ? "" : s.substring(startIndex, endIndex + 1);
	}

	public static void main(String[] args) {
	}
}
