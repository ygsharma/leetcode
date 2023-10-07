class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int idx = 0;
        int gSum = 0, cSum = 0, diff = 0;
        for(int i = 0; i < gas.length; i++) {
           diff += gas[i]-cost[i];
           gSum += gas[i];
           cSum += cost[i];
        // if diff < 0 make start index = i+1 and diff = 0
           if(diff < 0) {
               idx = i+1;
               diff = 0;
           }
        }
        // if total gas > total costreturn -1
        if(gSum - cSum < 0) return -1;
        return idx;
    }
}
