package Math;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 
 * *
 * @param s
 * @return
 * 
 * 
 * videoLink: https://leetcode.com/problems/roman-to-integer/description/
 * 
 * problem Link : https://youtu.be/dlATMslQ6Uc
 */




public class RomanToInteger {
	
	public static int romanToInt(String s) {
	    Map<Character,Integer> map = new LinkedHashMap<Character,Integer>(); 
	        map.put('I',1);
	        map.put('V',5);
	        map.put('X',10);
	        map.put('L',50);
	        map.put('C',100);
	        map.put('D',500);
	        map.put('M',1000);    
	       
	       int len = s.length();
	       int result = map.get(s.charAt(len-1));
	       
	       // here we have to do only 2 operations either add up
	       // value of roman to result or subtract for special cases
	       for(int i = len-2;i>=0;i--){
	           int a = map.get(s.charAt(i));
	           int currPrevChar = map.get(s.charAt(i+1));
	           result = a<currPrevChar?result-a:result+a;
	       }
	       return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
