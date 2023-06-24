package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    
    List<String> result;
    
    // map the characters to the indices 2 - 9
    String[] digitToChars = new String[] {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    }; 
    
    public List<String> letterCombinations(String digits) {
        this.result = new ArrayList<>();
        if (digits.length() == 0) 
            return result;
        // Compute the result recursively
        compute(0, digits, new char[digits.length()]);
        return result;
    }
    
    private void compute(int index, String digits, char[] combination) {
        
        // if the index reaches the end, means a possible combination is created
        // Add it to the result
        if (index == digits.length())
            result.add(new String(combination));
        else {
            int digit = digits.charAt(index) - '0'; // for eg: input: 23 --> take 2 first
            String digitChars = digitToChars[digit]; // get the mapping of 2 -> "abc",  now iterate over abc 
            
            // Use all the characters for the current digit one at a time 
            // and compute the rest of the result
            for (int i = 0; i < digitChars.length(); i++) {
                combination[index] = digitChars.charAt(i);
                compute(index + 1, digits, combination);
            }
        }
        
        
        
        
    }
}


