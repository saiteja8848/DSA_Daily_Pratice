package com.teja.leetcode.Math;

import java.util.HashMap;
import java.util.Map;


/**



LEETCODE Link : https://leetcode.com/problems/fraction-to-recurring-decimal/description/
gfg Link  :https://www.geeksforgeeks.org/find-recurring-sequence-fraction/

**/


public class FractionToRecurringDecimal {
	
	 public String fractionToDecimal(int numerator, int denominator) {
	        if(numerator==0)
	            return "0";
	        StringBuilder answer = new StringBuilder();
	        answer.append(((numerator>0)^(denominator>0))?"-":"");
	        long num = Math.abs((long)numerator);
	        long den = Math.abs((long)denominator); 
	        answer.append(num/den);
	        num%=den; // remainder is next value 
	        if(num==0)
	         return answer.toString();
	         answer.append(".");
	        //Now fractional part, so here we can wrap up by getting remainder 0 or continue the adding decimals
	        Map<Long, Integer> map = new HashMap<Long,Integer>();
	        map.put(num,answer.length()); // starting remainder where repeatation got started
	    
	        while(num!=0){
	             num*=10;
	             answer.append(num/den);
	             num%=den;
	             if(map.containsKey(num)){
	                 int startIndex = map.get(num);
	                 answer.insert(startIndex,"(");
	                 answer.append(")");
	                 break;
	             }else
	               map.put(num,answer.length());
	        } 
	        return answer.toString();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
