package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();

		for (String string : strs) {

			HashMap<Character, Integer> fmap = new HashMap<>();
			for (char ch : string.toCharArray()) {
				fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
			}

			if (map.containsKey(fmap) == false) {
				ArrayList<String> al = new ArrayList<>();
				al.add(string);
				map.put(fmap, al);
			} else
				map.get(fmap).add(string);

		}

		List<List<String>> result = new ArrayList<>();
		for (ArrayList<String> arr : map.values()) {
			result.add(arr);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
