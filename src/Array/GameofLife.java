package Array;

//题目描述:给定一个二维board，值为1代表live，值为0代表die。每一个值的8个neighbor(上下左右对角线)，如果值为1
//        并且neighbor值为1的个数小于2，下一步值会变成0，如果值为1并且neighbor中值为1的个数为2或者3，值仍
//        为1，如果值为1并且neighbor中值为1的个数大于3，下一步值变成0，如果值为0并且有3个值为1 的neighbor，
//        下一步会变成1,要求计算下一步之后所有的值
//解法描述:用0，1，2，3来表示状态，0表示die->die, 1表示live->live, 2表示live->die,3表示die->live，然后统计
//        每个cell的neighbor设定状态，最后状态为0或者2的变成die，1或者3变成live

public class GameofLife {

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { 0, -1, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int count = 0;
                for (int k = 0; k < dx.length; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && (board[x][y] == 1 || board[x][y] == 2)) {
                        ++count;
                    }
                }

                if (board[i][j] == 1 && (count < 2 || count > 3)) // 根据neighbor数量设定状态
                    board[i][j] = 2;
                else if (board[i][j] == 0 && count == 3)
                    board[i][j] = 3;
            }
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] %= 2;
            }
        }
    }
}
