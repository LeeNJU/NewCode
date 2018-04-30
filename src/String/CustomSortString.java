package String;

//题目描述:给定两个字符串S和T，都只包含字母，S中的元素是唯一的，S定义了元素之间的相对顺序，重新排序T，使得T中的元素满足S中定义的排序规则，例如S = "cba"，T = "abcd"
//       S定义了c->b->a的排序规则，那么T中的元素必须遵守，没有规定的元素，位置随便，返回任意一种有效的字符串，返回"cbad"
//解法描述:记录T中元素的次数，对于在S中已经定义的元素，按照S的顺序添加，最后对于没有定义的元素，加到结尾

public class CustomSortString {

    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) {
            ++count[c - 'a'];
        }

        StringBuilder result = new StringBuilder();
        for (char c : S.toCharArray()) {
            // 注意这里要循环相加，因为该元素可能在T中出现多次
            while (count[c - 'a']-- > 0) {
                result.append(c);
            }
        }

        for (char c : T.toCharArray()) {
            // 也要用循环，元素可能出现多次
            while (count[c - 'a']-- > 0) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
