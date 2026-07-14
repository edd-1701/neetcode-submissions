class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        

        var gasSum = 0;
        var costSum = 0;

        var globalFuel = 0;
        var result = 0;

        for (var i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];

            globalFuel += gas[i] - cost[i];

            if (globalFuel < 0) {
                globalFuel = 0;
                result = i + 1;
            }
        }

        return gasSum < costSum ? -1 : result;
    }
}
