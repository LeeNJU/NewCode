package String;

//题目描述:给定一个screen，长为rows，宽为cols，和一个单词字符串数组，把数组中的字符串放进screen中，每个字符串相隔一个空格，求能把字符串数组放进几次screen，例如
//        rows = 3, cols = 6, sentence = ["a", "bcd", "e"], return 2,因为 a-bcd-
//                                                                        e-a---
//                                                                        bcd-e-
//解法描述:直接遍历判断

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int result = 0;
        int i = 0, j = 0;
        while (i < rows && j < cols) {

            int k = 0;
            for (; k < sentence.length && i < rows && j < cols; ++k) {
                String word = sentence[k];
                // 当前行不能放下当前单词
                if (cols - j < word.length()) {
                    ++i;
                    j = 0;
                    --k;
                } else {
                    j += word.length() + 1;
                    if (j >= cols) {
                        j = 0;
                        ++i;
                    }
                }
            }

            if (k >= sentence.length) {
                ++result;
            } else {
                break;
            }
        }

        return result;
    }
}
