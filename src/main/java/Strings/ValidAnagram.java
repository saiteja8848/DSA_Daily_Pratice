package Strings;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {

		// Ascii value of a is 97, so, if we take a string abcdef
		// so how we get the indexs is
		/*
		 * a-'a' = 97-97=0 exact index numbers think them as alphabets 0 - a b-'a' =
		 * 98-97=1 c-'a' = 99-97=2
		 * 
		 * but for A, ascii value is 'A' A- 'A' = 65-65 B -'A' = 66 -65
		 * 
		 */

		if (s.length() != t.length())
			return false;
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
