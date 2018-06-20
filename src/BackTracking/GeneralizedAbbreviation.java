package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定字符串，求出所有可能的缩写，例如给定"word",那么可能的缩写结果是["word", "1ord", "w1rd", "wo1d", "wor1",
//        "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
//解法描述:递归穷举，每一个字符有两种可能，进行缩写和不进行缩写，如果进行缩写，就要避免连续的数字

public class GeneralizedAbbreviation {

    private void dfs(int index, String word, String s, List<String> result, boolean prevNum) {
        if (index >= word.length()) {
            result.add(s);
            return;
        }

        dfs(index + 1, word, s + word.charAt(index), result, false);
        // 上一步没有添加数字
        if (!prevNum) {
            for (int i = index; i < word.length(); ++i) {
                dfs(i + 1, word, s + Integer.toString(i - index + 1), result, true);
            }
        }
    }

    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        dfs(0, word, "", result, false);
        return result;
    }
}
