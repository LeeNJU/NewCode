package String;

//题目描述：给定两个数字字符串，将这两个字符串按照二进制进行相加，返回结果
//解法描述：两个指针分别逆序遍历两个字符串进行相加，最后把结果反转
public class AddBinary {

    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        String result = "";
        while (i >= 0 || j >= 0) {
            int c1 = (i >= 0 ? a.charAt(i) : '0') - '0';
            int c2 = (j >= 0 ? b.charAt(j) : '0') - '0';

            result = Integer.toString((c1 + c2 + carry) % 2) + result;
            carry = (c1 + c2 + carry) / 2;

            --i;
            --j;
        }

        if (carry > 0) {
            result = "1" + result;
        }

        return result;
    }
}
