package Stack;

public class ValidParenthesis {
      public boolean isValid(String s) {
        if(s==null||s.length()%2==1)
            return false;
        if(s.isEmpty())
			return true;
       Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='[')
                stack.push(']');
            else if(c=='{')
                stack.push('}');
            else 
                 if(stack.isEmpty()||stack.pop()!=c)
                return false; 
        }
        
        return stack.isEmpty();  
    }
}
