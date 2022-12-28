package com.teja.leetcode.bitwise;


/**


Video Link : https://youtu.be/m4L_5qG4vG8

GFG Link : https://www.geeksforgeeks.org/divide-two-integers-without-using-multiplication-division-mod-operator/

Leetcode Link  : https://leetcode.com/problems/divide-two-integers/



Here Input : is 2 int numbers are given
Output : Quotient of 2 numbers, we have to provide

Condition : We are not allowed to use "* or  % or /" operators

Approach 1 : subtract divident by divisor as long as its valid
     long quotient = 0;
     while (dividend >= divisor) {
          dividend -= divisor;
          ++quotient;
      }
Time complexity : O(a/b) 
Auxiliary space : O(1)

Approach 2: 
dividend = quotient * divisor + remainder 
Basic Idea : a/b = e ln(a) / e ln(b) = e( ln(a) – ln(b) )

Time complexity : O(log(a)) 
Auxiliary space : O(1)

Example : Divident =10, divisor=3
 
10 - 3 (7)>=0 ,so double divisor and move on, count=1
10 - 6 (4)>=0 ,so double divisor and move on, count=2
10 - 12(-2) >=0 false

result  = 1<<count, count=2, left shit means multiply by 2
result=2,

Now update dividend =  10 - 6 = 4

4-3(1)>=0, count=1
4-6(-2)>=0, false

update result = 2 + 1 = 3

*/






public class divideTwoIntegers {
	
	 public static int divide(int dividend, int divisor) {
	        //overflow condition checking
	        if(dividend == 1<<31 && divisor ==-1)
	          return Integer.MAX_VALUE;
	       //sign checking
	       boolean sign = (dividend>=0) == (divisor>=0) ? true : false;
	       dividend = Math.abs(dividend);
	       divisor = Math.abs(divisor);
	       int result=0;
	       while(dividend-divisor>=0){
	           int count=0;
	           while(dividend-(divisor<<1<<count)>=0){
	               count++;
	           }
	           result+=1<<count;
	           dividend-=divisor<<count;
	       }
	       return sign?result:-result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
