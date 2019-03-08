package UnionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//题目描述:给定一个字符串数组，表示字符是否相等，例如"a==b","b!=a"，判断字符能不能满足所有的关系，例如"a==b","b!=a"就不能满足关系
//解法描述:union find，对于所有相等关系的equation进行union find算法，找到所有相等的字符，然后再检查不等的equation，看是否满足

public class SatisfiabilityofEqualityEquations {

    private char root(char c, Map<Character, Character> map) {
        char a = c;
        while (map.getOrDefault(c, c) != c) {
            c = map.get(c);
        }

        map.put(a, c);
        return c;
    }

    public boolean equationsPossible(String[] equations) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        // 对所有相等关系的equation找到所有相等的字符
        Arrays.stream(equations)
                .filter(equation -> equation.charAt(1) == '=')
                .forEach(equation -> {
                    char root1 = root(equation.charAt(0), map);
                    char root2 = root(equation.charAt(3), map);

                    if (root1 != root2) {
                        map.put(root1, root2);
                    }
                });

        // 检查是否满足不等关系
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                continue;
            }

            char root1 = root(equation.charAt(0), map);
            char root2 = root(equation.charAt(3), map);
            if (root1 == root2) {
                return false;
            }
        }

        return true;
    }
}
