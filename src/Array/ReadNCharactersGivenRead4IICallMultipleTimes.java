package Array;

import Util.Reader4;

//题目描述:给定一个read4的api，每次只能读4个字符，要求实现read，每次读取任意的字符，最后返回实际读取的字符，例如实际字符串是"filetestbuffer"，read(6)返回"filete",
//       read(5)返回"stbuf"，read(4)返回"fer"
//解法描述:用一个大小为4的char数组作为，

public class ReadNCharactersGivenRead4IICallMultipleTimes extends Reader4 {

    // buffer数组
    private char[] buff = new char[4];
    // index表示available的字符下标
    private int index = buff.length;
    // count表示buffer数组里面实际有多少个字符，可能少于4个
    private int count = buff.length;

    public int read(char[] buf, int n) {

        int i = 0;
        while (i < n) {
            // 先读取buffer数组里的字符
            while (index < count && i < n) {
                buf[i++] = buff[index++];
            }

            if (i >= n) {
                break;
            }

            count = read4(buff);
            // 没有数据了
            if (count == 0) {
                break;
            }

            index = 0;
        }

        return i;
    }
}
