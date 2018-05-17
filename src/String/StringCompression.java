package String;

//题目描述:给定一个字符数组，进行压缩，例如["a","b","b","b","b","b","b","b","b","b","b","b","b"]，压缩成["a","b","1","2"]
//解法描述:遍历依次压缩

public class StringCompression {

    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }

        int index = 0;
        int count = 1;
        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == chars[i - 1]) {
                ++count;
                continue;
            }

            if (count == 1) {
                chars[index++] = chars[i - 1];
            } else {
                chars[index++] = chars[i - 1];
                String s = Integer.toString(count);
                for (int j = 0; j < s.length(); ++j) {
                    chars[index++] = s.charAt(j);
                }
            }

            count = 1;
        }

        if (count == 1) {
            chars[index++] = chars[chars.length - 1];
        } else {
            chars[index++] = chars[chars.length - 1];
            String s = Integer.toString(count);
            for (int j = 0; j < s.length(); ++j) {
                chars[index++] = s.charAt(j);
            }
        }

        return index;
    }
}
