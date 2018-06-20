package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个字符串只包含数字和字母，对于字母，可以变化成小写或者大写或者不变，求所有可能的字符串，例如给定S = "a1b2"，返回["a1b2", "a1B2", "A1b2", "A1B2"]
//解法描述:递归

public class LetterCasePermutation {

    private void dfs(int index, String s, String t, List<String> result) {
        if (index >= s.length()) {
            result.add(t);
            return;
        }

        Character character = s.charAt(index);
        dfs(index + 1, s, t + character, result);

        if (Character.isLowerCase(character)) {
            dfs(index + 1, s, t + Character.toUpperCase(character), result);
        }

        if (Character.isUpperCase(character)) {
            dfs(index + 1, s, t + Character.toLowerCase(character), result);
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        dfs(0, S, "", result);
        return result;
    }
}
