package String;

//题目描述：求出第n个count-and-say序列，1,11,21,1211,111221，……
//n=1时，读作1个1，所以是1，n=2时，看前一个序列，读作1个1，所以是11，n=3时，看前一个序列，读作2个1，所以是21，……
//解法描述：扫描计数
public class CountandSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String prev = "1";
        int k = 1;
        while (k < n) {
            int count = 1;
            StringBuilder cur = new StringBuilder();
            for (int i = 1; i < prev.length(); ++i) {
                if (prev.charAt(i) == prev.charAt(i - 1)) {
                    ++count;
                } else {
                    cur.append(Integer.toString(count))
                            .append(prev.charAt(i - 1));
                    count = 1;
                }
            }

            cur.append(Integer.toString(count))
                    .append(prev.charAt(prev.length() - 1));
            ++k;
            prev = cur.toString();
        }

        return prev;
    }
}
