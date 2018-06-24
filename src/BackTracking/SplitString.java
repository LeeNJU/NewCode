package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述:
//解法描述:

public class SplitString {

    private void dfs(int index, String s, List<String> list, List<List<String>> result) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(Character.toString(s.charAt(index)));
        dfs(index + 1, s, list, result);
        list.remove(list.size() - 1);

        if (index < s.length() - 1) {
            list.add(s.substring(index, index + 2));
            dfs(index + 2, s, list, result);
            list.remove(list.size() - 1);
        }
    }

    public List<List<String>> splitString(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, s, new ArrayList<String>(), result);
        return result;
    }
}
