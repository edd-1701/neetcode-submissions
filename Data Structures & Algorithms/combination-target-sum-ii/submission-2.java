/**


*/
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;

        Arrays.sort(candidates);
        helper(0, 0, new ArrayList<Integer>(), candidates);
        return result;
    }

    private void helper(int i, int currSum, List<Integer> subset, int[] nums) {

        if (currSum == target) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if (i == nums.length || currSum > target) {
            return;
        }

        subset.add(nums[i]);
        helper(i + 1, currSum + nums[i], subset, nums);
        subset.removeLast();

        var nextUniqueIdx = i + 1;
        while (nextUniqueIdx < nums.length && nums[nextUniqueIdx] == nums[i]) {
            nextUniqueIdx += 1;
        }
        helper(nextUniqueIdx, currSum, subset, nums);
    }
}
