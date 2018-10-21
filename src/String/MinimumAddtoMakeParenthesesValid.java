package String;

//题目描述:给定一个字符串，只包含(和),判断最少需要添加多少个括号使得它是匹配的，例如"())"，添加1一个(就能匹配
//解法描述:扫描一遍，计算还需要匹配的左括号的个数balance，balance为正，表示左括号多，balance为负，表示右括号多

public class MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        int ans = 0, balance = 0;

        for (int i = 0; i < S.length(); ++i) {
            balance += S.charAt(i) == '(' ? 1 : -1;
            // balance等于-1，需要一个(来匹配)
            if (balance == -1) {
                ++ans;
                ++balance;
            }
        }

        // balance为正，表示多余的(,需要)来匹配
        return ans + balance;
    }
}
