class Solution {
    public int[] twoSum(int[] numbers, int target) {
        var left = 0;
        var right = numbers.length - 1;

        while (left < right) {
            final var currSum = numbers[left] + numbers[right];

            if (currSum < target) {
                left += 1;
            } else if (currSum > target) {
                right -= 1;
            } else {
                return new int[]{left+1, right+1};
            }
        }

        return new int[]{0,0};
    }
}
