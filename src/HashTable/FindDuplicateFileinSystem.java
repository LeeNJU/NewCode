package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//题目描述:给定一个字符串数组，包含文件内容，文件目录等信息，找到所有文件内容相同的文件，例如"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
//        文件目录是root/d1/d2/.../dm, f1.txt是文件名
//解法描述:扫描字符串，用文件的内容作为hashmap的key
//follow up:如果文件很大，内存不够，就对文件进行hash，例如MD5，然后作为hashmap的key，坏处就是即使只有少量重复文件，也要全部扫描然后hash，改进办法是，根据文件大小分组
//         只考虑文件大小一样的，然后选取前1000个字符进行hash分组，如果相同，再进行1000-2000个字符分组，一直进行

public class FindDuplicateFileinSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.stream(paths)
                .forEach(path -> {
                    String[] files = path.split(" ");
                    String dir = files[0];
                    for (int i = 1; i < files.length; ++i) {
                        int index = files[i].indexOf("(");
                        String fileName = files[i].substring(0, index);
                        String content = files[i].substring(index + 1, files[i].length() - 1);

                        List<String> list = map.getOrDefault(content, new ArrayList<String>());
                        list.add(dir + "/" + fileName);
                        map.put(content, list);
                    }
                });

        return map.keySet()
                .stream()
                .filter(key -> map.get(key)
                        .size() > 1)
                .map(key -> map.get(key))
                .collect(Collectors.toList());
    }
}
