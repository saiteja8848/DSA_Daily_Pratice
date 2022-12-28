package Math;

/*
 * ProblemLink : https://leetcode.com/problems/excel-sheet-column-number/
 * 
 *  A - 1
   B - 2
   .... Z-26

   BC ==> (26*2) + 3 = 52 + 3 = 55
   HERE IF WE OBSERVE 
    26 single digit characters
   A26 , plus 26 single digit characters combinated with A
   so, total it is 26 + 26 =52 (26*2)
   plus B with 3 combinations = 3
   52+3

   same thing goes with AAB also, ACBC also

   TC:O(N)
   SC:O(1)
   LOGIC: 
   1. traverse the string from left to right, intially single digit characters
      so, it is 0 combinations with 26
   2. for second iteration we multiple with 26, means we did 1 round of iteration
   3. we do sum since we are adding previousCount+currentCount etc 

   A-65 to Z-97
   so A-A=0+1=1
 * 
 * 
 * 
 * */


public class ExcelSheetColumnNumber {
	
	  public int titleToNumber(String columnTitle) {
	        int result=0;
	        for(char ch:columnTitle.toCharArray()){
	            result*=26;
	            result+=ch-'A'+1;
	        }
	       return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
