package UnionFind;

//题目描述:给定一个没有边的图，满足以下操作，connect把两个点连接起来，query返回图中connecting component的个数
//解法描述:union find

public class ConnectingGraph {

    private int count;
    private int[] vec;

    private int root(int i) {
        while (i != vec[i]) {
            i = vec[i];
        }

        return i;
    }

    public ConnectingGraph(int n) {
        count = n;
        vec = new int[n];
        for (int i = 0; i < n; ++i) {
            vec[i] = i;
        }
    }

    public void connect(int a, int b) {
        int root1 = root(a - 1);
        int root2 = root(b - 1);
        if (root1 != root2) {
            vec[root1] = root2;
            --count;
        }
    }

    public int query() {
        return count;
    }
}
