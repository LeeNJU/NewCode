package String;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个字符串只包含+和-，现在把连续的两个++变成两个连续的--，求最后会得到多少种结果
//解法描述:扫描一遍
public class FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<String>();

        for (int i = 1; i < s.length(); ++i) {
            if (s.substring(i - 1, i + 1)
                    .equals("++")) {
                list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }

        return list;
    }

    // 题目描述:给定一个字符串只包含+和-，两个人轮流把连续的+变成-，经过变换后，如果没有连续的++，那么该人获胜，
    // 判断该人是否获胜
    // 解法描述:递归，遍历所有的解
    public boolean canWin(String s) {
        int index = 0;
        // 找到一个连续的++
        while ((index = s.indexOf("++", index)) != -1) {
            // 把连续的++变成-，然后递归判断
            if (!canWin(s.substring(0, index) + "--" + s.substring(index + 2))) {
                return true;
            }

            ++index;
        }

        return false;
    }
}
