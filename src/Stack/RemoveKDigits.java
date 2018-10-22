package Stack;

import java.util.Stack;

//题目描述:给定一个字符串表示一个数字，去掉其中的k个数字，使得剩下的数字是最小的，例如"1432219",k = 3,去掉
//        3个数字之后得到的最小数字是1219
//解法描述:遍历字符串，对于每个字符，如果比结果字符串的最后一个字符要小，说明能替换最后一个字符，组成更小的
//        数字，替换末尾比当前字符大的字符。这样进行替换之后，得到的字符串尽量会是递增的字符串

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int keep = num.length() - k;
        Stack<Character> stack = new Stack<Character>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                --k;
                stack.pop();
            }

            stack.add(c);
        }

        final String result = stack.stream()
                .limit(keep)
                .map(c -> Character.toString(c))
                .reduce((a, b) -> a + b)
                .orElse("0")
                .replaceFirst("^0+(?!$)", "");
        return result.isEmpty() ? "0" : result;
    }
}
