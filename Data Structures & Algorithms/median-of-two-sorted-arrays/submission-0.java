class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        final var merged = new int[nums1.length + nums2.length];

        var aPtr = 0;
        var bPtr = 0;
        var mergedIndex = 0;
        while (mergedIndex < merged.length) {
            var numA = aPtr < nums1.length ? nums1[aPtr] : Integer.MAX_VALUE;
            var numB = bPtr < nums2.length ? nums2[bPtr] : Integer.MAX_VALUE;

            merged[mergedIndex++] = Math.min(numA, numB);

            if (numA <= numB) {
                aPtr += 1;
            } else {
                bPtr += 1;
            }
        }

        // System.out.println(Arrays.toString(merged));
        /*
            len = 13
                elem at 7, or 0-indexed 6



            len = 12
                average between 6 - 7, or 0-indexed 5-6
        */


        if (merged.length % 2 == 0) {
            final var middle = merged.length / 2;
            return Double.valueOf(merged[middle-1] + merged[middle]) / 2;
        }

        return merged[merged.length / 2];

    }
}
