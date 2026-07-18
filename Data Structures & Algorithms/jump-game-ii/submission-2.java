/*
    Maintain a greedy sliding window
    
    At each jump
        process the window from left to right
            update furthest jump tp max reachable
    
    update left pointer to right + 1
    update right pointer to furthest jump
    increment totalJumps by 1 (we made a jump)

    return totalJumps

*/
class Solution {
    public int jump(int[] nums) {
        var minJumps = 0;

        var left = 0;
        var right = left;

        while (right < nums.length - 1) {
            var furthestIndex = 0;

            for (var i = left; i <= right; i++) {
                furthestIndex = Math.max(furthestIndex, i + nums[i]);
            }

            left = right + 1;
            right = furthestIndex;
            minJumps += 1;
        }


        return minJumps;
    }
}
