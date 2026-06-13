class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        final var result = new ArrayList<List<Integer>>();
        for (var i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            twoSumHelper(nums, result, i);
        }

        return result;
    }


    private void twoSumHelper(int[] nums, List<List<Integer>> triplets, int indexAt) {
        final var targetSum = 0 - nums[indexAt];

        var left = indexAt + 1;
        var right = nums.length - 1;

        while (left < right) {
            final var currSum = nums[left] + nums[right];

            if (currSum < targetSum) {
                left += 1;
            } else if (currSum > targetSum) {
                right -= 1;
            } else {
                triplets.add(List.of(nums[indexAt], nums[left], nums[right]));
                left += 1;
                right -= 1;

                while (left < right && nums[left] == nums[left-1]) {
                    left += 1;
                }
            }
        }
    }
}
