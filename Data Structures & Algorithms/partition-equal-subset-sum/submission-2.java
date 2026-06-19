class Solution {
    private int[] nums;
    private int target;
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;

        var sum = 0;
        for (var num : nums) {
            sum += num;
        }

        if (sum % 2 > 0) {
            return false;
        }

        target = sum / 2;
        return backtrack(0, 0);
    }

    private boolean backtrack(int indexAt, int currSum) {
        if (currSum == target) {
            return true;
        } else if (indexAt >= nums.length) {
            return currSum == target;
        }

        final var memoKey = "" + indexAt + "," + currSum;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        final var currNum = nums[indexAt];

        var useNum = false;
        if (currSum + currNum <= target){
            useNum = backtrack(indexAt + 1, currSum + currNum);
        }
        final var skipNum = backtrack(indexAt + 1, currSum);

        final var result = useNum || skipNum;
        memo.put(memoKey, result);
        return result;
    }
}
