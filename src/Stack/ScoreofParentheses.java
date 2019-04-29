package Stack;

//题目描述:给定一个balanced parentheses字符串，只包含(和),有如下规则，()得1分，(A)得2 * A分，AB得A + B的分数，A和B都是balanced parentheses，求字符串的分数，例如
//        "(()(()))"得分是6，"()()"得分2，"(())"得分2
//解法描述:可以用栈来模拟得分的过程，也可以观察规律，括号嵌套的层数就是得分，嵌套一层得1分，嵌套二层的2分，嵌套三层得4分，依次类推，扫描字符串，记录嵌套的层数，每遇到一个
//       完整的(),利用嵌套层数直接计算分数

public class ScoreofParentheses {

    public int scoreOfParentheses(String S) {

        int count = 0, result = 0;
        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == '(') {
                ++count;
            } else {
                --count;

                // 遇到一个完整的()，count就是它的嵌套层数
                if (S.charAt(i - 1) == '(') {
                    result += 1 << count;
                }
            }
        }

        return result;
    }
}
