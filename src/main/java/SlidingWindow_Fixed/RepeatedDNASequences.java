package SlidingWindow_Fixed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/repeated-dna-sequences/
public class RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {

		/*
		 * Brute Force: Map<String,String> freq = new HashMap<>(); for(int
		 * i=0;i<s.length-9;i++){ String dna = s.substring(i,i+10);
		 * freq.put(dna,freq.getOrDefault(dna,0)+1); }
		 * 
		 * return
		 * freq.entrySet().stream().filter(e->e.getValue()>1).map(e->e.getKey()).collect
		 * (Collectors.toList());
		 */

		if (s == null || s.length() <= 10)
			return new ArrayList<String>();

		int startWindow = 0;
		int endWindow = 10;
		Set<String> seen = new HashSet<>(), repeated = new HashSet<>();

		while (endWindow <= s.length()) {
			String subString = s.substring(startWindow, endWindow);
			if (seen.contains(subString))
				repeated.add(subString);
			seen.add(subString);
			startWindow++;
			endWindow++;
		}
		return new ArrayList(repeated);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
