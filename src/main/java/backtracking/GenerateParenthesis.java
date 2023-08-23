package backtracking;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
        List<String> solution = new ArrayList<>();
        generateParenthesis(n,solution,"",0,0);
        return solution;    
    }
    
    void generateParenthesis(int n, List<String>solution, String result, int open,int close){
        
        if(result.length()==n*2){
            solution.add(result);
            return;
        }
        
        if(open<n)
            generateParenthesis(n,solution,result+"(",open+1,close);
        if(close<open)
            generateParenthesis(n,solution,result+")",open,close+1);
        
    
    }
}
