package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Topological Sort
 * Problem Link : https://practice.geeksforgeeks.org/problems/alien-dictionary/1
 * GFG Link : https://www.lintcode.com/problem/892/description?fromId=201&_from=collection
 *
 */



public class AlienDictionary {
	public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] inDeg=new int[K];
        for(int i=0;i<K;i++)
        	adj.add(new ArrayList<Integer>());
        for(int i=0;i<N-1;i++){
            String s1=dict[i];
            String s2=dict[i+1];
            for(int j=0;j<s1.length();j++){
                if(j<s2.length() && s1.charAt(j)!=s2.charAt(j)){
                    int node=(int)(s1.charAt(j)-'a');
                    int neg=(int)(s2.charAt(j)-'a');
                    adj.get(node).add(neg);
                    inDeg[neg]++;
                    break;
                }
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<K;i++){
            if(inDeg[i]==0)
                q.offer(i);
        }
        String ans="";
        while(!q.isEmpty()){
            int node=q.poll();
            ans=ans+(char)(node+97);
            for(int i:adj.get(node)){
                inDeg[i]--;
                if(inDeg[i]==0)
                     q.offer(i);
            }
        }
        return ans;
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//public class Solution {
//    /**
//     * @param words: a list of words
//     * @return: a string which is correct order
//     */
//    public String alienOrder(String[] words) {
//        // Topo sort
//        // Edge case
//        if(words == null || words.length == 0) return "";
//        
//        //1. Init inDegree & topoMap
//        HashMap<Character, Integer> inDegree = new HashMap<>();
//        HashMap<Character, List<Character>> topoMap = new HashMap<>();
//        for(String word : words)
//            for(char c : word.toCharArray()) {
//                inDegree.put(c, 0);
//                topoMap.put(c, new ArrayList<Character>());
//            }
//        
//        //2. Build Map
//        for(int i = 0; i < words.length - 1; i++) {
//            String w1 = words[i], w2 = words[i + 1];
//            for(int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
//                char parent = w1.charAt(j), child = w2.charAt(j);
//                if(parent != child) {
//                    inDegree.put(child, inDegree.get(child) + 1);
//                    topoMap.get(parent).add(child);
//                    break;
//                }
//            }
//        }
//        
//        //3. Topo sort
//        StringBuilder res = new StringBuilder();
//        while(!inDegree.isEmpty()) {
//            boolean flag = false;
//            for(Character c : inDegree.keySet()) {
//                if(inDegree.get(c) == 0) {
//                    flag = true;
//                    res.append(c);
//                    List<Character> children = topoMap.get(c);
//                    for(Character ch : children)
//                        inDegree.put(ch, inDegree.get(ch) - 1);
//                    inDegree.remove(c);
//                    break;
//                }
//            }
//            if(flag == false)
//                return "";
//        }
//        return res.toString();
//    }
//}
