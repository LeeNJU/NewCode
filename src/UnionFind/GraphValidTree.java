package UnionFind;

//题目描述:给定一个图，判断这个图是不是一个树
//解法描述:一个图是不是一个树，首先没有环，并且保证每个点都是相连的，边的数量必须是n - 1。用union-find来做。对每一条边进行union,如果root点相同，说明有环，最后判断边的
//       数量
public class GraphValidTree {

    int root(int i, int[] vec) {
        while (i != vec[i]) {
            i = vec[i];
        }

        return i;
    }

    public boolean validTree(int n, int[][] edges) {
        int[] vec = new int[n];
        for (int i = 0; i < n; ++i) {
            vec[i] = i;
        }

        for (int i = 0; i < edges.length; ++i) {
            int root1 = root(edges[i][0], vec);
            int root2 = root(edges[i][1], vec);

            if (root1 == root2) {
                return false;
            }

            vec[root1] = root2;
        }

        return n - 1 == edges.length;
    }
}
