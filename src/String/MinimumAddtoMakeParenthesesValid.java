package String;

//题目描述:给定一个字符串，只包含(和),判断最少需要添加多少个括号使得它是匹配的，例如"())"，添加1一个(就能匹配
//解法描述:扫描一遍，不要用stack保存每个左括号，只需要记录左括号的个数

public class MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        int stackSize = 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                ++stackSize;
                continue;
            }

            if (stackSize == 0) {
                ++count;
            } else {
                --stackSize;
            }
        }

        return stackSize + count;
    }
}
