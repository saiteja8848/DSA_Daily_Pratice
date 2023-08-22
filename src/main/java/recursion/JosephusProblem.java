package recursion;


public class JosephusProblem {
	public static void main(String[] args) {
	}
}

class Solution1589
{
    public int josephus(int n, int k){
        if(n == 1) 
           return 1;
        int position = josephus(n-1,k); 
        return (position + k-1) % n + 1; 
    }
    

    public int josephus2(int n, int k){
      int survivor = 0;
        for (int i = 2; i <= n; i++) {
            survivor = (survivor + k) % i;
        }
        return survivor + 1;
    }
    

     public int josephus3(int n, int k){
      if(n == 1) 
          return 0;
        int position = josephus(n-1,k);     
        return (position + k) % n; 
    }
    
}

