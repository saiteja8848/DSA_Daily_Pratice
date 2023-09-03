package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
       public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> row, pre=null;        
        for(int i=0;i<numRows;i++){
            row = new ArrayList();
            for(int j=0;j<=i;j++){
                row.add((j==0||j ==i) ? 1 :pre.get(j-1)+pre.get(j));
            }
            pre=row;
            answer.add(row);   
        }
        return answer;    
    }
}
