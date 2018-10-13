package BitManipulation;

//题目描述：给定值m和n，都是非负整数，求[m,n]这个范围内的数一次进行与操作之后的值
//解法描述：求从[m,n]这个范围内所有的数的二进制表示中左边相同的部分，例如[26,30],二进制表示为11010, 11011,
//         11100, 11101, 11110结果为11000先把m和n同时向右移动，直到二者相等，记录移动的次数，再把m向左移动相等的次数

public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            ++count;
        }
        return m << count;
    }
}
