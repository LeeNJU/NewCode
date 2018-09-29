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

    // 题目描述：给定一个数组，其中有两个数只出现一次，其余的树出现两次，找到这两个数
    // 解法描述：先对所有的数进行异或操作，得到的结果等于x和y进行异或的结果，由于x和y不可能相等，结果中必然有一位
    // 等于1,从右边开始找，找到等于1的那一位，然后以此把数组中的数分成两个部分，x和y分别在这两个部分中，
    // 对这两个部分的数进行异或，得到x和y
    public int[] singleNumber3(int[] nums) {
        int num = 0;
        for (int val : nums) {
            num ^= val;
        }

        int index = 0;
        while (num % 2 == 0) {
            num = num >> 1;
            ++index;
        }

        int[] result = { 0, 0 };
        for (int val : nums) {
            if ((val >> index) % 2 == 0) {
                result[0] ^= val;
            } else {
                result[1] ^= val;
            }
        }

        return result;
    }
}
