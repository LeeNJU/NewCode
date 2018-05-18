package String;

//题目描述：比较版本号数字，例如0.1 < 1.1 < 1.2 < 13.37.89，假设只有数字和点
//解法描述：分割字符串，用vector保存每个子串，然后转换成数字逐一比较,注意末尾是0的情况

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        // 注意这里的转义字符
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");

        int i = 0, j = 0;
        while (i < strings1.length || j < strings2.length) {
            int num1 = i < strings1.length ? Integer.parseInt(strings1[i]) : 0;
            int num2 = j < strings2.length ? Integer.parseInt(strings2[j]) : 0;

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            } else {
                ++i;
                ++j;
            }
        }

        return 0;
    }
}
