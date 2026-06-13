class Solution {
    public void setZeroes(int[][] matrix) {
        final var rowsToZero = new HashSet<Integer>();
        final var colsToZero = new HashSet<Integer>();

        for (var row = 0; row < matrix.length; row++) {
            for (var col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    rowsToZero.add(row);
                    colsToZero.add(col);
                }
            }
        }

        for (var idx : colsToZero) {
            //set cols to 0
            for (var row = 0; row < matrix.length; row++) {
                matrix[row][idx] = 0;
            }
        }

        for (var idx : rowsToZero) {
            //set row to 0
            for (var col = 0; col < matrix[0].length; col++) {
                matrix[idx][col] = 0;
            }
        }

    }
}
