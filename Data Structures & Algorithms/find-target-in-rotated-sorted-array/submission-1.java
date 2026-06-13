class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        //two binary searches, if array was rotated

        var rotateIdx = -1;
        for (var i = 1; i < nums.length; i++){
            if (nums[i] < nums[i-1]) {
                rotateIdx = i;
            }
        }

        // for (var i = 0; i < nums.length; i++){
        //     if (i == rotateIdx) {
        //     System.out.print("[" + nums[i] + "] ");
        //     } else {
        //     System.out.print(nums[i] + " ");
        //     }
        // }


        if (rotateIdx == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        
        final var leftSearchResult = binarySearch(nums, target, 0, rotateIdx - 1);
        if (leftSearchResult != -1 ) {
            return leftSearchResult;
        }

        return binarySearch(nums, target, rotateIdx, nums.length - 1);

    }

    private static int binarySearch(int[] nums, int target, int lBound, int rBound) {
        var left = lBound;
        var right = rBound;

        while (left <= right) {
            final var middle = (left + right) / 2;

            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
