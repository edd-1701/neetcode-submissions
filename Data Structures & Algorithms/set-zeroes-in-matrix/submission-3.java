/*
    Create two sets to store the row & col indexes to set 0
    scan the matrix:
        when 0 found, add to set, and break iteration

    go through the sets, and set to 0
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        final var rowIdxs = new HashSet<Integer>();
        final var colIdxs = new HashSet<Integer>();

        for (var r = 0; r < matrix.length; r++) {
            for (var c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] != 0) {
                    continue;
                }

                if (!rowIdxs.contains(r)) {
                    rowIdxs.add(r);
                }
                colIdxs.add(c);
            }
        }

        for (var row : rowIdxs) {
            for (var col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }

        for (var col : colIdxs) {
            for (var row = 0; row < matrix.length; row++) {
                matrix[row][col] = 0;
            }
        }


    }
}
