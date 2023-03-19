package SlidingWindow_Fixed;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagaramsInAString {

	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> output = new ArrayList<>();

		if (s.length() < p.length())
			return output;

		int[] hashmap = new int[128];
		for (char ch : p.toCharArray()) {
			hashmap[ch]++;
		}

		int beg = 0, end = 0, counter = p.length();
		while (end < s.length()) {
			if (hashmap[s.charAt(end++)]-- > 0)
				counter--;

			if (counter == 0)
				output.add(beg);

			if (end - beg == p.length() && hashmap[s.charAt(beg++)]++ >= 0)
				counter++;
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
