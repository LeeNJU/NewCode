package BackTracking;

//题目描述:给定整数N和K，第一行为0，依次为基点，遇到0就变成01，遇到1就变成10，第二行就是01，第三行就是0110，以此类推，求第N行的第K个数字，K是1-indexed
//解法描述:类似于一个树的结构，父节点为0，左右子节点为0和1，父节点为1，左右子节点为1和0
//       详情见https://www.cnblogs.com/grandyang/p/9027098.html

public class KthSymbolinGrammar {

    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }

        if (K % 2 == 0) {
            return 1 - kthGrammar(N - 1, K / 2);
        } else {
            return kthGrammar(N - 1, (K + 1) / 2);
        }
    }
}
