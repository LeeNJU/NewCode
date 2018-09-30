package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//题目描述：给定一个DNA字符串，只包含C，G，A和T字符，找到其中出现次数大于1的长度为10的子串
//解法描述：用位操作，用2位就可以对CGAT进行编码，长度为10的子串只需要一个int的20位就可以了，用hashtable保存每个值出现的次数，注意要去除重复元素

public class RepeatedDNASequences {

    private int getCode(final char c) {
        switch (c) {
        case 'A':
            return 0;
        case 'C':
            return 1;
        case 'G':
            return 2;
        case 'T':
        default:
            return 3;
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int num = 0;
        for (int i = 0; i < s.length(); ++i) {
            int code = getCode(s.charAt(i));
            num = ((num << 2) + code) & 0x000fffff;
            if (i < 9) {
                continue;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 2) {
                map.put(num, map.get(num) + 1);
                list.add(s.substring(i - 9, i + 1));
            }
        }

        return list;
    }
}
