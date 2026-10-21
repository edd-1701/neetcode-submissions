class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        var startRow = 0;
        var endRow = matrix.length - 1;
        var startCol = 0;
        var endCol = matrix[0].length - 1;

        final var result = new ArrayList<Integer>();

        while (startRow <= endRow && startCol <= endCol) {
            traverse(startRow, endRow, startCol, endCol, matrix, result);

            startRow += 1;
            endRow -= 1;
            startCol += 1;
            endCol -= 1;
        }

        return result;
    }

    private void traverse(
        int row1, int row2, int col1, int col2, int[][] matrix, List<Integer> nums) {
        // top row
        for (var c = col1; c <= col2; c++) {
            nums.add(matrix[row1][c]);
        }

        // right column
        for (var r = row1 + 1; r <= row2; r++) {
            nums.add(matrix[r][col2]);
        }

        // bottom row right to left
        if (row1 != row2) {
            for (var c = col2 - 1; c >= col1; c--) {
                nums.add(matrix[row2][c]);
            }
        }

        // left column bottom to top
        if (col1 != col2) {
            for (var r = row2 - 1; r > row1; r--) {
                nums.add(matrix[r][col1]);
            }
        }
    }
}
