/**

swap diagonally
then swap columns
*/
class Solution {
    public void rotate(int[][] matrix) {
        final var LEN = matrix.length;

        for (var row = 0; row < LEN; row++) {
            for (var col = row; col < LEN; col++) {
                final var tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }

        final var MID = LEN / 2;
        for (var row = 0; row < LEN; row++) {
            for (var col = 0; col < MID; col++) {
                final var tmp = matrix[row][col];

                matrix[row][col] = matrix[row][LEN - 1 - col];
                matrix[row][LEN - 1 - col] = tmp;
            }
        }
    }
}
