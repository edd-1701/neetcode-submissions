class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        helper(0, new ArrayList<Integer>());
        return result;
    }

    private void helper(int index, List<Integer> subset) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }


        // final var listCopy = new ArrayList<>(subset);
        subset.add(nums[index]);
        helper(index + 1, subset);
        subset.removeLast();

        var nextUniqueIndex = index + 1;
        while (nextUniqueIndex < nums.length && nums[nextUniqueIndex] == nums[index]) {
            nextUniqueIndex += 1;
        }
        helper(nextUniqueIndex, subset);
        
    }
}
