package Arrays;

public class ExcelSheet {
      public String convertToTitle(int columnNumber) {
        String ans = "";
        
        while(columnNumber > 0) {
            columnNumber--;
            ans= (char)((columnNumber) % 26 + 'A') + ans;
            columnNumber = (columnNumber) / 26;
        }
        return ans;
    }

    public int titleToNumber(String columnTitle) {
        int result=0;

        for(char ch:columnTitle.toCharArray()){
            result*=26;
            result+=ch-'A'+1;
        }
       return result;
    }
}
