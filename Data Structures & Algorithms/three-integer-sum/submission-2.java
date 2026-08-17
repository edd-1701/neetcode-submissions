class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        final var result = new ArrayList<List<Integer>>();

        for (var i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            twoSum(nums, i, result);
        }


        return result;

    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        var left = i + 1;
        var right = nums.length - 1;

        while (left < right) {
            final var currSum = nums[i] + nums[left] + nums[right];

            if (currSum < 0) {
                left += 1;
            } else if (currSum > 0) {
                right -= 1;
            } else {
                result.add(List.of(nums[i], nums[left], nums[right]));
                left += 1;
                right -= 1;

                while (left < right && nums[left] == nums[left - 1]) {
                    left += 1;
                }
            }
        }
    }
}
