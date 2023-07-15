package Bitwise;

public class BinaryToDecimalConversion {

	static int binaryToDecimal(int n) {
		int num = n;
		int dec_value = 0;
		int base = 1;
		int temp = num;
		while (temp > 0) {
			int last_digit = temp % 10;
			temp = temp / 10;
			dec_value += last_digit * base;
			base = base * 2;
		}
		return dec_value;
	}
	
	public static int binaryToDecimal10(int n){
	    int dec_num = 0;
	    int power = 0;
	    while (n > 0) {
	      if (n % 10 == 1) {
	        dec_num += (1 << power);
	      }
	      power++;
	      n = n / 10;
	    }
	    return dec_num;
	 }
	
	static int binaryToDecimal(String n){
        String num = n;
        int dec_value = 0;
 
        // Initializing base value to 1,
        // i.e 2^0
        int base = 1;
 
        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            if (num.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }
 
        return dec_value;
    }

	public static void main(String[] args) {
		
		Integer.parseInt("1001",2);
	}

}
