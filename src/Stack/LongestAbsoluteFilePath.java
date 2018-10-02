package Stack;

import java.util.Stack;

//题目描述:给定一个字符串表示文件之间的层级关系，例如
//        "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
//        表示
//        dir
//           subdir1
//              file1.ext
//              subsubdir1
//           subdir2
//              subsubdir2
//                 file2.ext
//        其中\t的个数表示层数
//解法描述:用栈，表示从根目录到当前目录或者文件的路径长度，'\t'表示层级关系，也就是有多少个父目录，当碰到文件的时候，算出长度。

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        String[] files = input.split("\n");
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        for (int i = 0; i < files.length; ++i) {
            int level = files[i].lastIndexOf("\t") + 1;
            while (level < stack.size() && !stack.isEmpty()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stack.add(files[i].length());
            } else {
                int length = stack.peek() + files[i].length() - level + 1;
                stack.add(length);
            }

            if (files[i].contains(".")) {
                result = Math.max(result, stack.peek());
            }
        }

        return result;
    }
}
