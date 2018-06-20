package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//题目描述：给定一个数字字符串，每个数字对应手机上的字母，找出所有可能的字母组合，例如"23", 解为["ad", "ae", "af",
//         "bd", "be", "bf", "cd", "ce", "cf"],因为数字2对应abc，数字3对应def
//解法描述：递归，用map保存数字与字母的对应关系，递归的层数作为digit的下标

public class LetterCombinationsofaPhoneNumber {

    private void dfs(int index, String digits, ArrayList<String> result, String t, HashMap<Character, List<Character>> map) {
        if (index >= digits.length()) {
            result.add(t);
            return;
        }

        map.get(digits.charAt(index))
                .stream()
                .forEach(character -> dfs(index + 1, digits, result, t + character, map));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        HashMap<Character, List<Character>> map = new HashMap<Character, List<Character>>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        ArrayList<String> result = new ArrayList<String>();
        dfs(0, digits, result, "", map);
        return result;
    }
}
