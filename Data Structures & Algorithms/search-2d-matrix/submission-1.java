class Solution {
    private int ROWS;
    private int COLS;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.ROWS = matrix.length;
        this.COLS = matrix[0].length;
        
        final var targetRow = rowSearch(matrix, target);

        // System.out.println("target row " + targetRow);
        if (targetRow == null) {
            return false;
        }
        
        return binarySearch(matrix[targetRow], target);

    }

    private boolean binarySearch(int[] row, int target) {
        var left = 0;
        var right = COLS - 1;

        while (left <= right) {
            var middle = (left + right) / 2;
            final var currNum = row[middle];

            if (currNum < target) {
                left = middle + 1;
            } else if (currNum > target) {
                right = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    private Integer rowSearch(int[][] matrix, int target) {
        var left = 0;
        var right = matrix.length -1;

        while (left <= right) {
            final var middle = (left + right) / 2;
            // System.out.println("\t middle row idx:" + middle);

            final var start = matrix[middle][0];
            final var end = matrix[middle][COLS-1];

            if (target >= start && target <= end) {
                return middle;
            } else if (target < start) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return null;
    }
}
