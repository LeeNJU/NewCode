package BitManipulation;

//题目描述:给定一个数组，数组中的元素都会出现2次，只有其中一个元素只出现1次，找出这个元素
//解法解法:对每个元素进行异或操作，因为出现2次的元素进行异或之后每一位等于0，再与剩下的元素进行异或，
//        结果不变，最终结果就是它

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
