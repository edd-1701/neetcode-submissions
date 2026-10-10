class Solution {
    public int rob(int[] nums) {
        var rob1 = 0;
        var rob2 = 0;

        for (var house : nums) {
            final var currMax = Math.max(house + rob1, rob2);
            rob1 = rob2;
            rob2 = currMax;
        }

        return rob2;
    }
}
