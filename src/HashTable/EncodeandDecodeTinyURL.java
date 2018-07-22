package HashTable;

import java.util.HashMap;

//题目描述:tiny url
//解法描述: 一个tiny url可以看做一个62进制的数，每一个long url产生一个唯一的key，这个key转换成62进制就是short url，用hashmap保存key和long url的映射关系

public class EncodeandDecodeTinyURL {

    private HashMap<Integer, String> map1 = new HashMap<Integer, String>();
    private HashMap<String, Integer> map2 = new HashMap<String, Integer>();
    private String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String encode(String longUrl) {
        if (!map2.containsKey(longUrl)) {
            map2.put(longUrl, map2.size() + 1);
            map1.put(map2.size(), longUrl);
        }

        int num = map2.get(longUrl);
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.append(s.charAt(num % 62));
            num /= 62;
        }

        return result.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int num = 0;
        for (int i = 0; i < shortUrl.length(); ++i) {
            num = num * 62 + s.indexOf(shortUrl.charAt(i));
        }

        return map1.get(num);
    }
}
