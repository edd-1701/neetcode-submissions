class Solution {
    public int missingNumber(int[] nums) {
        // var expectedSum = 0;
        // for (var i = 0; i < nums.length; i++) {
        //     expectedSum += i;
        // }
        // var actualSum = 0;
        // for (var num : nums) {
        //     actualSum += num;
        // }
        // return expectedSum - actualSum;

        var exOrSum = 0;
        for (var num : nums) {
            exOrSum ^= num;
        }

        for (var i = 0; i <= nums.length; i++) {
            exOrSum ^= i;
        }

        return exOrSum;
    }
}
