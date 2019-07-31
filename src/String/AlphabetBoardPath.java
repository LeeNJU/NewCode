package String;

//题目描述:给定一个字母表，target字符串，从[0,0]出发，要经过target字符串中的每个字符，求最短的序列，例如target = "leet"，返回"DDR!UURRR!!DDD!"
//        "abcde"
//        "fghij"
//        "klmno"
//        "pqrst"
//        "uvwxy"
//        "z"
//解法描述:算出相邻的字符之间的横坐标和纵坐标的距离就可以了，要注意z字符串，所以要先考虑向上走，然后向右走，向左走，向下走

public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        int x = 0, y = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < target.length(); ++i) {
            int length = target.charAt(i) - 'a';
            int row = length / 5;
            int col = length % 5;

            stringBuilder.append("U".repeat(Math.max(0, row - x)));
            stringBuilder.append("R".repeat(Math.max(0, col - y)));
            stringBuilder.append("L".repeat(Math.max(0, y - col)));
            stringBuilder.append("D".repeat(Math.max(0, x - row)));
            stringBuilder.append('!');

            x = row;
            y = col;
        }

        return stringBuilder.toString();
    }
}
