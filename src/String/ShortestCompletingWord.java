package String;

//题目描述:给定一个字符串licensePlate和字符串数组，找到字符串数组中长度最短的字符串，使得她们包含licensePlate中的字符，忽略大小写
//解法描述:把字母映射到26质数，如果包含licensePlate中的字符，那么乘积一定是它的倍数

public class ShortestCompletingWord {

    private long getProduct(final int[] primes, final String s) {
        long charProduct = 1l;
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetter(s.charAt(i))) {
                charProduct *= primes[s.charAt(i) - 'a'];
            }
        }

        return charProduct;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        final int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        licensePlate = licensePlate.toLowerCase();
        final long charProduct = getProduct(primes, licensePlate);

        String result = "0000000000000000";
        for (String word : words) {
            if (word.length() < result.length() && getProduct(primes, word) % charProduct == 0) {
                result = word;
            }
        }

        return result;
    }
}
