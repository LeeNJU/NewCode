package UnionFind;

//题目描述:给定一个二维数组表示n个同学之间的朋友关系，有朋友关系的形成一个group，求有多少个group
//解法描述:典型的union find问题，初始化一个数组表示n个元素，刚开始每个元素都是独立的group，p和q是朋友关系，把p指向q，形成一棵树的结构，如果两个元素最终指向同一个元素，
//        那么这两个元素属于同一个group，如果两个元素的root不同，把其中一个root指向另个一个root，完成合并

public class FriendCircles {

    private int root(int i, int[] vec) {
        while (i != vec[i]) {
            i = vec[i];
        }
        return i;
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] vec = new int[n];
        for (int i = 0; i < n; ++i) {
            vec[i] = i;
        }

        int count = n;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (M[i][j] == 1) {
                    int root1 = root(i, vec);
                    int root2 = root(j, vec);
                    if (root1 != root2) {
                        --count;
                        vec[root1] = root2;
                    }
                }
            }
        }

        return count;
    }
}
