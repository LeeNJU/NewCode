package UnionFind;

//题目描述:给定一个二维数组，表示两个节点之间的链接关系，这是本来是一棵树的结构，往其中加了一条边之后就有了环，形成无向图，找到这条环
//解法描述:union find

public class RedundantConnection {

    private int root(int i, int[] vec) {
        while (i != vec[i]) {
            i = vec[i];
        }

        return i;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] vec = new int[n];
        for (int i = 0; i < vec.length; ++i) {
            vec[i] = i;
        }

        int[] result = new int[2];
        for (int i = 0; i < edges.length; ++i) {
            int root1 = root(edges[i][0] - 1, vec);
            int root2 = root(edges[i][1] - 1, vec);

            if (root1 == root2) {
                result = edges[i];
            } else {
                vec[root1] = root2;
            }
        }

        return result;
    }
}
