package com.teja.leetcode.Math;

/*
 * 
 * 
 * Leetcode problem Link : https://leetcode.com/problems/excel-sheet-column-title/
 * 
 *  A - 1
   B - 2
   .... Z-26

  example : Input-26, output-z

  26)26(1
     26
    ---
     0

     remainder 0+26=26(1st letter from left, z)

Example 2: 28

1. subtract 1 from 28, since ascii codes start from 0 instead of 1


1.27>0

26)27(1
   26
------
 1

 1+65=66(char)=B

left over remainder = 1

26)0(0
 0
====
0

AB
   TC:OLog(N) with base 26, since for every iteration we are reducing the n value by 26
   SC:O(1)
   LOGIC: 

 * 
 * 
 * */


public class ExcelSheetColumnTitle {
	
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
        //return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
