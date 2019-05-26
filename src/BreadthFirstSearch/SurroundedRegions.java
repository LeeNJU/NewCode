package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

//题目描述:给定一个二维数组，只包含O或者X，找到所有被X包围的O，然后把这些O全部换成X，注意边界上的O不能被换成X
//解法描述:从边界上的O开始进行广搜或者深搜，把能够搜到的O全部换成#，那么剩下的O必然被X包围，然后扫描整个数组，把O换成X,然后把#换成O

public class SurroundedRegions {

    private void bfs(char[][] board, int i, int j) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i);
        queue.add(j);
        board[i][j] = '#';

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            int[] dx = { 1, -1, 0, 0 };
            int[] dy = { 0, 0, 1, -1 };
            for (int k = 0; k < dx.length; ++k) {
                int row = dx[k] + x;
                int col = dy[k] + y;

                if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O' || board[row][col] == '#') {
                    continue;
                }

                queue.add(row);
                queue.add(col);
                board[row][col] = '#';
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        for (int i = 0; i < board[0].length; ++i) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i);
            }

            if (board[board.length - 1][i] == 'O') {
                bfs(board, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; ++i) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }

            if (board[i][board[0].length - 1] == 'O') {
                bfs(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == '#') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
