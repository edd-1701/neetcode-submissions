/*

    Binary seach, but array is offset by an unknown 
    start the usual binary search skeleton:
        left = 0;
        right = len;

        create a minNumber var, initialized at nums[0]
        while left <= right:
            if nums[left] < nums[right]:


            middle = left + right / 2

            If 


*/

class Solution {
    public int findMin(int[] nums) {
        
        var left = 0;
        var right = nums.length - 1;
        var minNum = nums[0];
        while (left <= right) {
            if (nums[left] < nums[right]) {
                return Math.min(minNum, nums[left]);
            }

            final var middle = (left + right) / 2;
            minNum = Math.min(minNum, nums[middle]);
            if (nums[middle] >= nums[left]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            
        }

        return minNum;
    }
}
