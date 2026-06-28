/*
Approach

Before placing a queen check

create a board: List<List<String>>


iterate 0 -- n (number of queens to place):
    one queen would have to go in each row

    foreach column:
        check for location valid (horizontally, and upper diagonal directions)
        if valid -> place queen
        if invalid -> continue to other columns

    if a valid location found, continue on to next iteration
    if "soft-locked", backtrack to previous queen and start on a new row


return board

*/

class Solution {
    private final static char QUEEN = 'Q';
    private final static char BLANK = '.';
    
    private final List<List<String>> result = new ArrayList<>();

    private char[][] board;
    private Map<Integer, Integer> queenLocations = new HashMap<>();
    // private boolean resultFound = false;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (var row : board) {
            Arrays.fill(row, BLANK);
        }

        helper(0);

        return result;
    }

    private void helper(int row) {
        if (row == board.length) {
            result.add(convertBoardToResult());
            return;
        }

        for (var col = 0; col < board.length; col++) {
            if (!isValidPos(row, col)) {
                continue;
            }
            board[row][col] = QUEEN;
            helper(row + 1);
            board[row][col] = BLANK;
        }

    }

    private boolean isValidPos(int row, int col) {
        // check up
        var searchRow = row;
        while (searchRow >= 0) {
            if (board[searchRow][col] == QUEEN) {
                return false;
            }
            searchRow -= 1;
        }

        // check up/left diagonal
        searchRow = row;
        var searchCol = col;
        while (searchRow >= 0 && searchCol >= 0) {
            if (board[searchRow][searchCol] == QUEEN) {
                return false;
            }
            searchRow -= 1;
            searchCol -= 1;
        }

        searchRow = row;
        searchCol = col;
        while (searchRow >= 0 && searchCol < board.length) {
            if (board[searchRow][searchCol] == QUEEN) {
                return false;
            }
            searchRow -= 1;
            searchCol += 1;
        }

        return true;
    }

    private List<String> convertBoardToResult() {
        final var result = new ArrayList<String>();
        for (var originalRow : board) {
            result.add(new String(originalRow));
        }

        return result;
    }
}
