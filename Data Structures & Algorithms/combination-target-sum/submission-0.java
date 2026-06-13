class Solution {

    private int[] nums;
    private int target;
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.result = new ArrayList<>();
        Arrays.sort(nums);

        helper(0, new ArrayList<>(), target);

        return result;
    }

    /**
        [2,5,6,9]
        
        2
    */
    private void helper(int lastIndexAt, List<Integer> combination, int target) {
        if (lastIndexAt == nums.length) {
            return;
        }
        if (nums[lastIndexAt] == target) {
            final var comboCopy = new ArrayList<>(combination);
            comboCopy.add(nums[lastIndexAt]);
            result.add(comboCopy);
        } 
        if (nums[lastIndexAt] >= target || target < 0) {
            return;
        }

        combination.add(nums[lastIndexAt]);
        helper(lastIndexAt, combination, target - nums[lastIndexAt]);
        combination.removeLast();
        helper(lastIndexAt + 1, combination, target);
    }
}
