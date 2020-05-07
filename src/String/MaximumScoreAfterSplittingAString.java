package String;

//题目描述:给定一个字符串S，只包含0和1，把它分成两个非空的子字符串，左边的字符串统计0的个数，右边的字符串统计1的个数，使得他们的和最大
//       例如, "011101",分成"0"和"11101",长度是5
//解法描述:遍历一遍得到1的总个数，然后再遍历一遍，统计左边字符串0和1的个数

public class MaximumScoreAfterSplittingAString {

  public int maxScore(String s) {
    int totalOne = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '1') {
        ++totalOne;
      }
    }

    int zero = 0;
    int one = 0;
    int total = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '1') {
        ++one;
      } else {
        ++zero;
      }

      total = Math.max(total, zero + totalOne - one);
    }

    return total;
  }
}