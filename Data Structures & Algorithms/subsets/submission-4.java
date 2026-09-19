class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        final var result = new ArrayList<List<Integer>>();
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, i + 1, subset, result);
        subset.removeLast();
        backtrack(nums, i + 1, subset, result);
    }
}
