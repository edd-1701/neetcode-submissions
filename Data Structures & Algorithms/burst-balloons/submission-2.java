/*
    - Copy the array with padded borders [1, ...., 1]
    - create a memoization table
    - call a recursive function that takes in (int left, int right)

    for each value from left to right, simulate it as the last popped balloon,
        coins = nums[leftBorder-1] * nums[i] * nums[rightBorder+1]
        coins = helper(left, i - 1) + helper(i+1, right)
        result = Math.max(memo[l][r], coins)

    return memor[l][r]
    
*/

class Solution {
    private int[] nums;
    private Integer[][] memo;

    public int maxCoins(int[] nums) {
        final var LEN = nums.length + 2;

        this.nums = new int[LEN];
        this.nums[0] = 1;
        this.nums[LEN - 1] = 1;
        for (var i = 0; i < LEN - 2; i++) {
            this.nums[i+1] = nums[i];
        }

        memo = new Integer[LEN][LEN];

        return helper(1, LEN - 2);


    }

    private int helper(int left, int right) {

        //if invalid state 
        if (left > right) {
            return 0;
        }

        //if memoized, return solution
        if (memo[left][right] != null) {
            return memo[left][right];
        }

        var result = 0;
        for (var i = left; i<= right; i++) {
            var coins = nums[left - 1] * nums[i] * nums[right + 1];
            coins += helper(left, i-1) + helper(i+1, right);
            result = Math.max(result, coins);
        }

        memo[left][right] = result;
        return result;

    }
}
