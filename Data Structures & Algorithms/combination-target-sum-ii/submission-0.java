class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int target;
    private int[] nums;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        this.nums = candidates;
    
        Arrays.sort(nums);

        helper(candidates.length - 1, new ArrayList<>(), 0);

        return result;
    }

    private void helper(int index, List<Integer> list, int currSum) {
        if (currSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (index < 0 || currSum > target) {
            return;
        }

        final var currNum = nums[index];

        // final var listCopy = new ArrayList<>(list);
        list.add(currNum);

        helper(index - 1, list, currSum + currNum);
        list.removeLast();

        var nextDistinct = index - 1;
        while (nextDistinct >= 0 && nums[nextDistinct] == nums[index]) {
            nextDistinct -= 1;
        }

        helper(nextDistinct, list, currSum);
    }
}
