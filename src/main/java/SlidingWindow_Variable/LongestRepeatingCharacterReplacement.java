package SlidingWindow_Variable;

import java.util.HashMap;


/**
 * 
 * @author saiteja 
 * ProblemLink :https://leetcode.com/problems/longest-repeating-character-replacement
 * Tc: O(n) SC : O(1)
 */


public class LongestRepeatingCharacterReplacement {
	 public int characterReplacement(String s, int k) {
	        
	        HashMap<Character,Integer> map = new HashMap<>();
	        int startWindow=0;
	        int endWindow=0;
	        int maxReplacements =0;
	        int maxCharCount=0;
	        //maxReplacements = len(substring) - maxRepeatingCharInSubstr
	        while(endWindow<s.length()){
	            char ch = s.charAt(endWindow); 
	            
	            map.put(ch, map.getOrDefault(ch,0)+1);
	            maxCharCount=Math.max(maxCharCount,map.get(ch));
	            
	        
	            while((endWindow-startWindow+1)-maxCharCount>k){
	                map.put(s.charAt(startWindow), map.get(s.charAt(startWindow))-1 );
	                startWindow++;
	            }
	            maxReplacements = Math.max(maxReplacements,endWindow-startWindow+1) ;
	            
	            endWindow++;
	        }
	        return maxReplacements;
	        
	    }
	public static void main(String[] args) {
	}
}
