package BackTracking;

import java.util.HashMap;
import java.util.Map;

//题目描述:给定两个字符串，判断能不能匹配，例如pattern = "abab"， str = "redblueredblue",返回true因为"a"->"red","b"->"blue"
//解法描述:由于每个字符可以匹配多个，只能穷举所有的匹配方式

public class WordPatternII {

    private boolean dfs(final String pattern, int i, final String str, int j, Map<Character, String> map1, Map<String, Character> map2) {
        if (i >= pattern.length() && j >= str.length()) {
            return true;
        } else if (i >= pattern.length() || j >= str.length()) {
            return false;
        }

        Character character = pattern.charAt(i);
        // 当前字符之前已经匹配过了，但是不能继续匹配
        if (map1.containsKey(character) && (map1.get(character)
                .length() > str.length() - j || !str.startsWith(map1.get(character), j))) {
            return false;
        }

        // 当前字符已经匹配过了，并且可以继续匹配
        if (map1.containsKey(character)) {
            return dfs(pattern, i + 1, str, j + map1.get(character)
                    .length(), map1, map2);
        }

        for (int index = j; index < str.length(); ++index) {
            String string = str.substring(j, index + 1);
            // 当前字符串已经匹配了别的字符
            if (!map2.getOrDefault(string, character)
                    .equals(character)) {
                continue;
            }

            map1.put(character, string);
            map2.put(string, character);

            // 找到一种匹配，递归求解
            if (dfs(pattern, i + 1, str, index + 1, map1, map2)) {
                return true;
            }

            map1.remove(character);
            map2.remove(string);
        }

        return false;
    }

    public boolean wordPatternMatch(String pattern, String str) {
        return dfs(pattern, 0, str, 0, new HashMap<>(), new HashMap<>());
    }
}
