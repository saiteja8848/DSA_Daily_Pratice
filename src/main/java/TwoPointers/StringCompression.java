package TwoPointers;



public class StringCompression {
	
	  public int compress(char[] chars) {
	        int n = chars.length;
	        int i = 0, j = 0;
	        while (i < n) {
	            int count = 1;
	            while (i + 1 < n && chars[i] == chars[i + 1]) {
	                i++;
	                count++;
	            }
	            chars[j] = chars[i];
	            j++;
	            if (count > 1) {
	                String countStr = String.valueOf(count);
	                for (int k = 0; k < countStr.length(); k++) {
	                    chars[j] = countStr.charAt(k);
	                    j++;
	                }
	            }
	            i++;
	        }
	        return j;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
