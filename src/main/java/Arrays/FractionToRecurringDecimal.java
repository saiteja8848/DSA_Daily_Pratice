package Arrays;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int num, int denom) {
        if(denom==0)
          return "undefined";
        if(num==0)
           return "0";

        String sign = ((num>0)^(denom>0))?"-":"";
        
        long numerator = Math.abs((long)num);
        long denominator = Math.abs((long)denom);

        StringBuilder result = new StringBuilder();
        result.append(sign);
        result.append(numerator/denominator);
      
        numerator=numerator%denominator;
        if(numerator==0)
         return result.toString();
        result.append(".");
      
        Map<Long,Integer> trackQuotient = new HashMap<>();
        trackQuotient.put(numerator , result.length());
        while(numerator!=0){
            numerator*=10;
            result.append(numerator/denominator);
            numerator=numerator%denominator;
            if(trackQuotient.containsKey(numerator)){
                int index = trackQuotient.get(numerator);
                result.insert(index,"(");
                result.append(")");
                break;
            }else
              trackQuotient.put(numerator,result.length());
        }
      return result.toString();
    }
}
