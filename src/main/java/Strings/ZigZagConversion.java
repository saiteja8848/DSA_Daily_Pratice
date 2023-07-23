package Strings;

import java.util.Arrays;

public class ZigZagConversion {

	public String convert(String s, int n) {
		if (n == 1)
			return s;

		StringBuilder result = new StringBuilder();

		for (int rowNum = 0; rowNum < n; rowNum++) {
			int i = rowNum;
			boolean up = true;

			while (i < s.length()) {
				result = result.append(s.charAt(i));
				if (rowNum == 0 || rowNum == n - 1) {
					i += (2 * n - 2);
				} else {
					if (up) {
						i += (2 * (n - rowNum) - 2);
					} else {
						i += rowNum * 2;
					}
					up = up ^ true;
				}
			}
		}
		return result.toString();
	}
	
	 public String convert1(String s, int n) {
	        if(n==1)
	          return s;

	        String[] str = new String[n];
	        Arrays.fill(str,"");    
	  
	        int row=0;
	        boolean down=true;
	      
	        for(char ch: s.toCharArray()){
	            str[row]+=ch;
	            if(row==n-1)
	               down=false;
	            else if(row==0)
	               down=true;

	            if(down)
	              row++;
	            else
	              row--;   
	        }  

	       String result="";
	        for(int i=0;i<n;i++){
	             result+=str[i];
	        }
	     return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
