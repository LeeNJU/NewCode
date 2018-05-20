package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//题目描述：给定一个字符串表示Unix风格的目录，要求对这个目录进行简化，其中.表示当前目录， ..表示父目录
//解法描述：根据"/"进行split

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] files = path.split("/");
        List<String> list = new ArrayList<String>();

        for (String file : files) {
            // 连续的//,那么file是空的
            if (file.isEmpty() || file.equals(".")) {
                continue;
            }

            if (file.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
                continue;
            }

            list.add(file);
        }

        return "/" + list.stream()
                .collect(Collectors.joining("/"));
    }
}
