package String;

//题目描述:给定一个字符串数组，找到两个字符串使得它们长度的乘积最大，并且这两个字符串之间没有公共字符
//解法描述:把每一个字符串转换成int数字，因为只有26个字母，可以用int值代替，然后进行与操作，如果没有公共字符，与操作结果是0

public class MaximumProductofWordLengths {

    private int convert(final String word) {
        int num = 0;
        for (int i = 0; i < word.length(); ++i) {
            num |= (1 << (word.charAt(i) - 'a'));
        }

        return num;
    }

    public int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                if ((convert(words[i]) & convert(words[j])) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }
}
