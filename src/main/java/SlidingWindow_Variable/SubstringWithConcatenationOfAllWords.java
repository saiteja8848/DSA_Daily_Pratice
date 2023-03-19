package SlidingWindow_Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution3 {
    public List<Integer> findSubstring(String s, String[] words) {

        Map<String,Integer> wordsCount = new HashMap<>();
        for(String word:words)
            wordsCount.put(word,wordsCount.getOrDefault(word,0)+1);
    
        List<Integer> result = new ArrayList<>();
        int wordsCnt = words.length;
        int wordLength = words[0].length();
        
        for(int i=0;i<=s.length()-wordsCnt*wordLength;i++){
            Map<String,Integer> seen=new HashMap<>();
            for(int j=0;j<wordsCnt;j++){
                int nextIndexOfWord = i+j*wordLength;
                String nextWord=s.substring(nextIndexOfWord,nextIndexOfWord+wordLength);
                
                if(!wordsCount.containsKey(nextWord))
                    break;
                
                seen.put(nextWord,seen.getOrDefault(nextWord,0)+1);
                
                if(seen.get(nextWord)>wordsCount.getOrDefault(nextWord,0))
                    break;
                
                if(j+1==wordsCnt)
                    result.add(i);    
            }   
        }
        return result;
    }
}

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
