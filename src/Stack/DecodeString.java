package Stack;

import java.util.Stack;

//题目描述:给定一个字符串，格式如下，数字表示括号内的字符串需要重复的次数，返回最后的字符串，例如s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return "accaccacc".
//      s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
//解法描述:用两个栈，一个保存数字，一个保存字符串，当遇到"]",先把栈中的字符串连接起来，根据数字重复n遍，然后压入栈中。

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();

        for (int i = 0; i < s.length();) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int index = i;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    ++index;
                }
                nums.push(Integer.parseInt(s.substring(i, index)));
                i = index;
            } else if (ch == '[') {
                strs.push("[");
                ++i;
            } else if (Character.isLetter(ch)) {
                int index = i;
                while (index < s.length() && Character.isLetter(s.charAt(index))) {
                    ++index;
                }
                strs.push(s.substring(i, index));
                i = index;
            } else if (ch == ']') {
                // 注意这里，要把栈中的字符串连接起来，然后再重复
                String string = "";
                while (!strs.peek()
                        .equals("[")) {
                    string = strs.pop() + string;
                }
                strs.pop();

                int count = nums.pop();
                StringBuilder stringBuilder = new StringBuilder();
                while (count > 0) {
                    stringBuilder.append(string);
                    --count;
                }

                strs.push(stringBuilder.toString());
                ++i;
            }
        }

        String result = "";
        while (!strs.isEmpty()) {
            result = strs.pop() + result;
        }

        return result;
    }
}
