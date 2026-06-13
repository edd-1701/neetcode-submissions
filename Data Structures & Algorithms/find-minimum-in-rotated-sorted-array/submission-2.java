class Solution {
    public int findMin(int[] nums) {

        var left = 0;
        var right = nums.length -1;

        var minNum = nums[0];
        while (left <= right) {
            if (nums[left] < nums[right]) {
                return Math.min(minNum, nums[left]);
            }

            final var middle = (left + right) / 2;

            minNum = Math.min(minNum, nums[middle]);
            if (nums[middle] >= nums[left]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return minNum;
    }
}
/*

    [3,4,5,6,1,2]

*/