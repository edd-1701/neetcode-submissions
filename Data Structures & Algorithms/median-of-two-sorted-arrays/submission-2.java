class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final var LEN = nums1.length + nums2.length;
        final var IS_ODD = LEN % 2 != 0;
        final var MIDDLE_IDX = LEN / 2;

        var i = 0;
        var p1 = 0;
        var p2 = 0;
        var leftNumForEvenLen = 0d;
        while (p1 < nums1.length || p2 < nums2.length) {
            var num1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
            var num2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;

            if (IS_ODD && i == MIDDLE_IDX) {
                return Math.min(num1, num2);
            }

            if (!IS_ODD && i == MIDDLE_IDX - 1) {
                leftNumForEvenLen = Math.min(num1, num2);
            }

            if (!IS_ODD && i == MIDDLE_IDX) {
                return (leftNumForEvenLen + Math.min(num1, num2)) / 2;
            }

            if (num1 <= num2) {
                p1 += 1;
            } else {
                p2 += 1;
            }

            i += 1;
        }


        return 0d;
    }
}
