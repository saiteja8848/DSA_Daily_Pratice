package backtracking;

public class DecodeWays {

	 Map<Integer, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        
        return back(s, 0);
    }
    
    private int back(String s, int start){
        if(start == s.length()) return 1;
        
        if(memo.containsKey(start)) return memo.get(start);
        
        int ans = 0;
        for(int i = start + 1; i <= s.length(); i++){
            if(Integer.parseInt(s.substring(start, i)) > 26) break;
            if(Integer.parseInt(s.substring(start, i)) == 0) return 0;
            
            ans += back(s, i);
        }
        
        memo.put(start, ans);
        return ans;
    }

}
