package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个字符串，例如2-1-1，添加括号，使得算出的值不同，问有多少种不同的结果,((2-1)-1) = 0,(2-(1-1)) = 2
//解法描述:递归，以运算符号为中心进行划分，运算符两边分别求出不同的左值和右值，然后根据左值和右值的集合，进行
//        计算,应该要考虑计算结果的唯一性

public class DifferentWaystoAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            if (Character.isDigit(input.charAt(i))) {
                continue;
            }

            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));

            for (int m : left) {
                for (int n : right) {
                    if (input.charAt(i) == '-') {
                        list.add(m - n);
                    } else if (input.charAt(i) == '*') {
                        list.add(m * n);
                    } else {
                        list.add(m + n);
                    }
                }
            }
        }

        if (list.isEmpty()) {
            list.add(Integer.parseInt(input));
        }

        return list;
    }
}
