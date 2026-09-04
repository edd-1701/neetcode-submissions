class Solution {
    public int singleNumber(int[] nums) {
        var missing = 0;

        for (var num : nums) {
            missing ^= num;
        }

        return missing;
    }
}
