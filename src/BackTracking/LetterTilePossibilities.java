package BackTracking;

//题目描述:给定一个字符串，只包含大写字母，找到所有可能非空的子序列的个数，例如"AAB"，"A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"，返回8
//解法描述:统计每个字符的次数，然后根据字符的次数进行递归计算，递归的每一步添加一个字符，类似于求出所有可能的排列组合的解法，只是不保存所有的可能，只需要计数

public class LetterTilePossibilities {

    // 返回以当前字符频率 所有的个数
    private int dfs(int[] count) {
        int sum = 0;
        for (int i = 0; i < count.length; ++i) {
            if (count[i] == 0) {
                continue;
            }

            // 每一步选择一个字符
            ++sum;
            --count[i];
            sum += dfs(count);
            ++count[i];
        }

        return sum;
    }

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            ++count[c - 'A'];
        }

        return dfs(count);
    }
}
