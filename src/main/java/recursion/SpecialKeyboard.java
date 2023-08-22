package recursion;


// /*
//  *  Example  : N=7
//  *   
//  *   RESULT = 7, 8, 9,5
//  * CASE 1 : 7 A's is the maximum
//  * CASE 2 : DECREASE A by 1 and increase paste by 1, AAAAca|Cc|Cv. (7-3) = 4 A's and 4*2=8
//  * CASE 3:  3 A's * 3 Cv = 9
//  * CASE 4 : 2A's * 4 Cv= 8
//  * CASE 5 : 1A's * 5Cv = 5
//  * 
//  * /


public class SpecialKeyboard {
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

     static int optimalKeys(int N)
    {
        // code here
        int dp[] = new int[N+1];
        for(int i=0;i<=6 && i<=N;i++)
        dp[i] = i;
        
        for(int i=7;i<=N;i++)
        {
            for(int j=i-3;j>=1;j--)
            {
                dp[i] = Math.max(dp[i],dp[j]*(i-j-1));
            }
        }
        return dp[N];
    }

}
