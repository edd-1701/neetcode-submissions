class Solution {
    public void rotate(int[][] matrix) {
        final var LEN = matrix.length;

        //swap diagonally
        for (var row = 0; row < LEN; row++) {
            for (var col = row; col < LEN; col++) {
                final var tmpCell = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmpCell;
            }
        }

        //flip vertically: swap columns 
        final var midPoint = LEN / 2;
        for (var row = 0; row < LEN; row++) {
            for (var col = 0; col < midPoint; col++) {

                final var tmpCell = matrix[row][col];
                matrix[row][col] = matrix[row][LEN - 1 - col];
                matrix[row][LEN - 1 - col] = tmpCell;
            }
        }
    }
}
