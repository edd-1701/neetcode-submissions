class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        var gasUsed = 0;
        var gasCost = 0;

        var tripNetFuel = 0;
        var resultIndex = 0;

        for (var i = 0; i < gas.length; i++) {
            gasUsed += gas[i];
            gasCost += cost[i];

            tripNetFuel += (gas[i] - cost[i]);

            if (tripNetFuel < 0) {
                tripNetFuel = 0;
                resultIndex = i + 1;
            }
        }

        return gasUsed < gasCost ? -1 : resultIndex;
    }
}
