package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个数字组成的字符串，找出所有可能的ip地址，例如"25525511135"，返回["255.255.11.135", "255.255.111.35"]
//解法描述:递归，注意要确保ip地址每个部分都是有效的，例如必须小于255，长度不能超过3，以0开头的部分只能是0

public class RestoreIPAddresses {

    private void dfs(int index, String s, int dot, String str, List<String> list) {
        if (index >= s.length()) {
            if (dot == 0) {
                list.add(str.substring(1));
            }
            return;
        }

        if (dot <= 0) {
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            String string = s.substring(index, i + 1);
            // 长度不能大于3，不能超过255，不能是01或者00这种
            if (string.length() > 3 || Integer.parseInt(string) > 255 || string.charAt(0) == '0' && string.length() > 1) {
                continue;
            }
            dfs(i + 1, s, dot - 1, str + "." + string, list);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        dfs(0, s, 4, "", list);
        return list;
    }
}
