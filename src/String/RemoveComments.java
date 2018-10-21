package String;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个字符串数组，表示一组程序代码，里面包含注释，//和/* */,要求去除注释，得到剩下的字符串传，例如
//        source = ["/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ",
//        "   comment for ", "   testing */", "a = b + c;", "}"],返回["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]
//解法描述:扫描遍历，要注意当前字符串是否在/* */中

public class RemoveComments {

    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<String>();
        boolean blockComment = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : source) {
            if (!blockComment) {
                stringBuilder = new StringBuilder();
            }
            for (int i = 0; i < s.length(); ++i) {
                if (blockComment) {
                    int index = s.indexOf("*/", i);
                    if (index == -1) {
                        break;
                    }

                    blockComment = false;
                    i = index + 1;
                } else {
                    if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        break;
                    } else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        blockComment = true;
                        ++i;
                    } else {
                        stringBuilder.append(s.charAt(i));
                    }
                }
            }

            if (!blockComment && stringBuilder.length() != 0) {
                list.add(stringBuilder.toString());
            }
        }

        return list;
    }
}
