class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        recurse(nums, 0, new ArrayList<>());

        return result;        
    }

    private void recurse(int[] nums, int indexAt, List<Integer> subset) {
        if (indexAt >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[indexAt]);
        recurse(nums, indexAt + 1, subset);
        subset.removeLast();
        recurse(nums, indexAt + 1, subset);
    }
}
