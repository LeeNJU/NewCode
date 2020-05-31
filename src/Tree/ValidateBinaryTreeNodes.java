package Tree;

//题目描述:给定一个二叉树0到n - 1，第i个节点的左子节点是leftChild[i],右子节点是rightChild[i], -1表示没有子节点，判断是不是一个树
//解法描述:除了根节点，每个节点的入度必须是1，不能有环

public class ValidateBinaryTreeNodes {

  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    if (n < 2) {
      return true;
    }

    int[] indegree = new int[n];
    int childCount = 0;

    for (int i = 0; i < leftChild.length; ++i) {
      if (leftChild[i] != -1) {
        ++indegree[leftChild[i]];
        ++childCount;

        if (indegree[leftChild[i]] > 1) {
          return false;
        }
      }

      if (rightChild[i] != -1) {
        ++indegree[rightChild[i]];
        ++childCount;

        if (indegree[rightChild[i]] > 1) {
          return false;
        }
      }
    }

    // 子节点的个数必须是n - 1
    if (childCount != n - 1) {
      return false;
    }

    // 找到根节点
    int root = 0;
    for (int i = 0; i < n; ++i) {
      if (indegree[i] == 0) {
        root = i;
        break;
      }
    }

    // 根节点必须有子节点
    return leftChild[root] != -1 || rightChild[root] != -1;
  }
}
