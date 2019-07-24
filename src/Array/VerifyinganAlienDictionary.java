package Array;

//题目描述:给定字符串数组，order字符串表示自定义的字母的顺序，判断字符串数组中的字符串是不是按照自定义的方式已经排好序，例如
//       words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//解法描述:暴力解，遍历字符串数组进行比较，通过自定的函数比较字符串，把order字符串映射成下标

public class VerifyinganAlienDictionary {

    private boolean small(final String word1, final String word2, int[] index) {
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length() && word1.charAt(i) == word2.charAt(j)) {
            ++i;
            ++j;
        }

        if (i < word1.length() && j < word2.length()) {
            return index[word1.charAt(i) - 'a'] < index[word2.charAt(j) - 'a'];
        }

        return i >= word1.length();
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; ++i) {
            if (!small(words[i - 1], words[i], index)) {
                return false;
            }
        }

        return true;
    }
}
