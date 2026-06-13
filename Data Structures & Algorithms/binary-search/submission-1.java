class Solution {
    public int search(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            final var middleIdx = (left + right) / 2;

            final var currNum = nums[middleIdx];

            if (currNum < target) {
                left = middleIdx + 1;
            } else if (currNum > target) {
                right = middleIdx - 1;
            } else {
                return middleIdx;
            }
        }

        return -1;
    }
}
