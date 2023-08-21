package SlidingWindow_Fixed;

import java.util.LinkedHashSet;
import java.util.Set;

public class SubstringsOfSize3WithDistinctCharacters {

	public int countGoodSubstrings(String s) {
		int l = s.length();
		int i = 0, j = 0, k = 3, count = 0;
		while (j < l) {
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				if (s.charAt(i) != s.charAt(j) && s.charAt(j) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 1))
					count++;
				i++;
				j++;
			}
		}
		return count;

	}

	//Make sure of removing the startCharacter in case of new start or in case of duplicates
    public int countGoodSubstrings2(String s) {
        int count=0;
        
        int windowStart=0, end=0;
        Set<Character> differentCharacters = new LinkedHashSet();
        while(end<s.length()){
            //if there are duplicates, then remove and start with new substring
            while(differentCharacters.contains(s.charAt(end))){
                differentCharacters.remove(s.charAt(windowStart));
                windowStart++;
            }
            
            //If no duplicates
            differentCharacters.add(s.charAt(end));
            if(end-windowStart+1==3){
                count++;
                differentCharacters.remove(s.charAt(windowStart));
                windowStart++;
            }
            end++;
        }        
        return count;
    }
}
