package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//题目描述:给定一个字符串数组，找出所有的anagrams,anagram是指字符串中字符种类个数都一样，只是顺序不一样的字
//        符串，例如{"aet", "tea","ate"}
//解法描述:将每个字符串排序，把排序后的字符串作为map的key，存入哈希表中，然后检查某一个key对应的数组中字符串
//        的个数是否多于1

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

            if (hashMap.containsKey(s)) {
                hashMap.get(s)
                        .add(str);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                hashMap.put(s, list);
            }
        }

        Iterator<String> iterator = hashMap.keySet()
                .iterator();
        while (iterator.hasNext()) {
            result.add(hashMap.get(iterator.next()));
        }

        return result;
    }
}
