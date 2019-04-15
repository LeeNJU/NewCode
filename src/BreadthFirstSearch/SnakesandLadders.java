package BreadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//题目描述:hulu的题
//解法描述:bfs,关键在于下标的运算

public class SnakesandLadders {

    public int snakesAndLadders(int[][] board) {
        int moves = 0;
        int n = board.length;

        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        queue.add(1);
        set.add(1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int pos = queue.poll();
                if (pos == n * n) {
                    return moves;
                }

                for (int a = 1; a < 7 && pos + a <= n * n; ++a) {
                    int index = pos + a - 1;

                    int i = n - index / n - 1;
                    int j = (n - i) % 2 == 0 ? n - index % n - 1 : index % n;

                    index = board[i][j] == -1 ? index + 1 : board[i][j];
                    if (!set.contains(index)) {
                        queue.add(index);
                        set.add(index);
                    }
                }
            }

            ++moves;
        }

        return -1;
    }

}
