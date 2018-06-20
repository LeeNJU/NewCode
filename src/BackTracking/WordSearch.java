package BackTracking;

//题目描述:给定一个二维字符矩阵和一个字符串，从这个矩阵中找到一条路径，使得路径上的字符刚好组成给定的字符串，
//         只能垂直或水平寻找
//解法描述:深度搜索，用同样大小的矩阵visited表明各个元素是否已经被访问过了

public class WordSearch {

    private boolean dfs(int index, String word, int i, int j, char[][] board, boolean[][] visited) {
        if (index >= word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;
        boolean result = dfs(index + 1, word, i + 1, j, board, visited) || dfs(index + 1, word, i - 1, j, board, visited) || dfs(index + 1, word, i, j + 1, board, visited)
                || dfs(index + 1, word, i, j - 1, board, visited);
        visited[i][j] = false;
        return result;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                boolean result = dfs(0, word, i, j, board, visited);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }
}
