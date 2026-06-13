class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final var len = nums1.length + nums2.length;
        
        final var middleIdx = len / 2;
        final var isEvenLen = len % 2 == 0;

        var aPtr = 0;
        var bPtr = 0;
        var i = 0;

        var prevNumForEven = -1;
        while (aPtr < nums1.length || bPtr < nums2.length) {
            
            var numA = aPtr < nums1.length ? nums1[aPtr] : Integer.MAX_VALUE;
            var numB = bPtr < nums2.length ? nums2[bPtr] : Integer.MAX_VALUE;

            final var orderedNum = Math.min(numA, numB);
            
            if (!isEvenLen && i == middleIdx) {
                return orderedNum;
            }
            if (isEvenLen && i == (middleIdx - 1)) {
                prevNumForEven = orderedNum;
            }
           if (isEvenLen && i == middleIdx) {
                return Double.valueOf(prevNumForEven + orderedNum) / 2;
            }

            i += 1;
            if (numA <= numB) {
                aPtr += 1;
            } else {
                bPtr += 1;
            }
        }

        return 0d;
    }
}
