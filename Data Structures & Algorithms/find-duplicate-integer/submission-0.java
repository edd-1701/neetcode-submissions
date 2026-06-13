class Solution {
    public int findDuplicate(int[] nums) {
        
        // var expectedSum = 0;
        // var actualSum = 0;
        final var numSet = new HashSet<Integer>();

        for (var i = 0; i < nums.length; i++) {
            // actualSum += nums[i];
            // expectedSum += i + 1;
            if (!numSet.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;

        // return expectedSum - actualSum;
    }
}
