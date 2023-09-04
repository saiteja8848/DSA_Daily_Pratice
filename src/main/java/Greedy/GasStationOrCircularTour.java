package Greedy;

public class GasStationOrCircularTour {
  public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();

        if(totalGas<totalCost)
            return -1;
        
        int remainingGas=0;
        int start=0;
        
        for(int i=0;i<gas.length;i++){
            remainingGas+=gas[i]-cost[i];
            if(remainingGas<0){
                start=i+1;
                remainingGas=0;
            }
        }
        
        return start;
    }

}
