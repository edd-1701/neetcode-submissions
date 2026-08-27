class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final var ROWS = matrix.length;
        final var COLS = matrix[0].length;

        for (var row = 0; row < ROWS; row++) {
            if (target > matrix[row][COLS-1]) {
                continue;
            }

            if (target < matrix[row][0]) {
                return false;
            }

            var left = 0;
            var right = COLS - 1;

            while (left <= right) {
                final var middleIdx = (left + right) / 2;

                if (matrix[row][middleIdx] < target) {
                    left = middleIdx + 1;
                } else if (matrix[row][middleIdx] > target) {
                    right = middleIdx - 1;
                } else {
                    return true;
                }
            }
        }


        return false;
     }
}
