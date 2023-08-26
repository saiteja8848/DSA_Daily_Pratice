package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromeLength {
	public int longestPalindrome(String s) {
		Set<Character> set = new HashSet();
		// Even no of characters we are trying to remove - example : aabcd, aa will be
		// removed
		// bcd will left out in the set
		for (char ch : s.toCharArray()) {
			if (set.contains(ch)) {
				set.remove(ch);
				continue;
			}
			set.add(ch);
		}

		// since bcd is left out, size will be 3
		int oddCharacterLen = set.size();
		int totalLength = s.length();
		// we want to include only one odd character, so need -1 from oddCharactersLen
		// and rest all
		// should be removed
		// aabcd, aa removed, out of bcd, we keep only 1, so need to remove 2 character
		// from len
		return totalLength - (oddCharacterLen == 0 ? 0 : oddCharacterLen - 1);
	}
}
