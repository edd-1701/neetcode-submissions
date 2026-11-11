class Solution {
    public int maxProduct(int[] nums) {
        return solutionKadane(nums);
    }

    private int solutionKadane(int[] nums) {
        var result = nums[0];

        var tmpMax = 1;
        var tmpMin = 1;

        for (var num : nums) {
            final var curr = tmpMax * num;

            tmpMax = Math.max(num, Math.max(num * tmpMax, num * tmpMin));
            tmpMin = Math.min(num, Math.min(curr, num * tmpMin));

            result = Math.max(result, tmpMax);
        }


        return result;
    }
}
