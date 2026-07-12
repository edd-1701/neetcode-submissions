class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        var startRow = 0;
        var endRow = matrix.length - 1;
        var startCol = 0;
        var endCol = matrix[0].length - 1;

        final var result = new ArrayList<Integer>();
        while (startRow <= endRow && startCol <= endCol) {
            iterate(matrix, startRow, endRow, startCol, endCol, result);

            startRow += 1;
            endRow -= 1;
            startCol += 1;
            endCol -= 1; 
        }

        return result;
    }

    private void iterate(int[][] matrix, int r1, int r2, int c1, int c2, List<Integer> data) {
        for (var col = c1; col <= c2; col++) {
            data.add(matrix[r1][col]);
        }

        for (var row = r1 + 1; row <= r2; row++) {
            data.add(matrix[row][c2]);
        }

        if (r1 != r2) {
            for (var col = c2 - 1; col >= c1; col--) {
                data.add(matrix[r2][col]);
            }
        }

        if (c1 != c2) {
            for (var row = r2 - 1; row > r1; row--) {
                data.add(matrix[row][c1]);
            }
        }


    }
}
