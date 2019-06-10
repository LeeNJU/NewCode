package HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//题目描述:给定一个输入，表示domain的访问次数["9001 discuss.leetcode.com"]，每个subdomain的次数也要算，返回["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
//解法描述:hashmap记录每个的次数

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String input : cpdomains) {
            int index = input.indexOf(" ");
            int count = Integer.parseInt(input.substring(0, index));
            String domain = input.substring(index + 1);

            while (!domain.isEmpty()) {
                map.put(domain, map.getOrDefault(domain, 0) + count);
                index = domain.indexOf(".");
                domain = index != -1 ? domain.substring(index + 1) : "";
            }
        }

        return map.keySet()
                .stream()
                .map(key -> map.get(key) + " " + key)
                .collect(Collectors.toList());
    }
}
