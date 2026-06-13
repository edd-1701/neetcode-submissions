class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        final var rows = matrix.length;
        final var cols = matrix[0].length;

        var left = 0;
        var right = rows * cols - 1;

        while (left <= right) {
            final var middleIdx = (left + right) / 2;
            final var selectRow = middleIdx / cols;
            final var selectCol = middleIdx % cols;

            final var num = matrix[selectRow][selectCol];

            if (num < target) {
                left = middleIdx + 1;
            } else if (num > target) {
                right = middleIdx - 1;
            } else {
                return true;
            }
        }

        return false;

    }



}
