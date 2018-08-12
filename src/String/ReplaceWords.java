package String;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//题目描述:给定一个字典，和字符串数组，找到每个单词的最短的root，例如Input: dict = ["cat", "bat", "rat"]，sentence = "the cattle was rattled by the battery"
//          Output: "the cat was rat by the bat"
//解法描述:对字典排序，然后暴力解

public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict, Comparator.comparingInt(String::length));
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; ++i) {
            for (String root : dict) {
                if (words[i].startsWith(root)) {
                    words[i] = root;
                    break;
                }
            }
        }

        return String.join(" ", words);
    }
}
