import java.util.*;

class Solution {
    private List<List<String>> result;
    private int n;
    public void solve(int row, char[][] board) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(row + 1, board);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.n = n;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(0, board);
        return result;
    }
    private boolean isSafe(int row, int col, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}
