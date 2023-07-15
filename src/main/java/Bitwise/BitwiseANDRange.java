package Bitwise;

public class BitwiseANDRange {

	public int rangeBitwiseAnd(int left, int right) {
	        
	        //checking for the fist unmatched bit - how many shifts it took
	        int shiftCount=0;
	        while(left!=right){
	          left>>=1;
	          right>>=1;
	          shiftCount++;
	        }
	        return right<<shiftCount;

	        // int ans=left;
	        // for(int i=left+1;i<=right;i++){
	        //     ans=ans&i;
	        // }
	        // return ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
