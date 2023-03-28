package TwoPointers;

/*
 * 
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 */

public class ReverseWordsInAString {

	public String reverseWords(String s) {
		String result = "";
		int i = 0;
		int n = s.length();
		while (i < n) {
			// if there spaces, we move forward
			while (i < n && s.charAt(i) == ' ')
				i++;
			if (i >= n)
				break;
			// if there are no spaces, try to move forward
			int j = i + 1;
			while (j < n && s.charAt(j) != ' ')
				j++;

			String word = s.substring(i, j);
			result = result.isEmpty() ? word : word + " " + result;
			// continue the process for rest of the string
			i = j + 1;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
