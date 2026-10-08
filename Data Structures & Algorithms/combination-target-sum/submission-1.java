class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int[] nums;
    private int target;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        Arrays.sort(nums);

        helper(0, 0, new ArrayList<Integer>());

        return result;
    }

    private void helper(int i, int subsetSum, List<Integer> subset) {
        if (subsetSum > target || i == nums.length) {
            return;
        }

        if (subsetSum == target) {
            result.add(new ArrayList<>(subset));
            return;
        }

        final var currNum = nums[i];
        subset.add(currNum);
        helper(i, subsetSum + currNum, subset);
        subset.removeLast();
        helper(i + 1, subsetSum, subset);
    }
}
