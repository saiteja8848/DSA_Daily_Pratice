package TwoPointers;

/**
 * 
 * @author saiteja
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 */

public class FindIndexOfFirstOccurenceOfString {

	public int strStr(String haystack, String needle) {
		if (haystack.length() < needle.length())
			return -1;
		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				if (haystack.substring(i, i + needle.length()).equals(needle)) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
