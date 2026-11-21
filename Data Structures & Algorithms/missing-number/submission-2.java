class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        var expectedNum = 0;

        for (var num : nums) {
            if (num != expectedNum) {
                return expectedNum;
            }

            expectedNum += 1;
        }

        return expectedNum;
    }
}
