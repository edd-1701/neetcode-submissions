/**

    I want to do two binary searches

    start with usual binary search
    - if middle number is the target, return the index
    - if middle is greater than left, I know this is a sorted part of the array.
    - if middle is less than left, I know the array is rotated between middle and left
    - if middle is less than right, I know between middle and right is sorted
    - if middle is greater than right, I know array is rotated between middle and right

    From this I determine the boundaries of the search


*/

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            final var middle = (left + right) / 2;

            // System.out.println("Top level: l: %s, r: %s, middle: %s, nums[middle]: %s".formatted(
            //     left, right, middle, nums[middle]
            // ));

            if (nums[middle] == target) {
                return middle;
            }

            final var leftIsSorted = nums[middle] >= nums[left];
            final var targetLeftHalf = target >= nums[left] && target <= nums[middle];
            if (leftIsSorted && targetLeftHalf) {
                return binarySearch(left, middle, nums, target);
            } else if (leftIsSorted) {
                left = middle + 1;
                continue;
            }

            //right is sorted
            //if num SHOULD BE this sorted right half
            if (target >= nums[middle] && target <= nums[right]) {
                return binarySearch(middle, right, nums, target);
            } else {
                right = middle - 1;
                continue;
            }

            

            
        }

        return -1;
    }

    private static int binarySearch(int l, int r, int[] nums, int target) {
        while (l <= r) {
            final var middle = (l + r) / 2;


            // System.out.println("\tsecond level: l: %s, r: %s, middle: %s, nums[middle]: %s".formatted(
            //     l, r, middle, nums[middle]
            // ));


            if (nums[middle] < target) {
                l = middle + 1;
            } else if (nums[middle] > target) {
                r = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
