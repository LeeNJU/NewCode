package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树，序列化成一个字符串，然后根据字符串反序列化成一个二叉搜索树
//解法描述:利用先序遍历进行序列化，再递归反序列化

public class SerializeandDeserializeBST {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    private TreeNode dfs(String[] data, int i, int j) {
        if (i > j) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[i]));
        int index = i + 1;
        // 找到左子树的范围
        while (index <= j && Integer.parseInt(data[index]) < root.val) {
            ++index;
        }

        root.left = dfs(data, i + 1, index - 1);
        root.right = dfs(data, index, j);
        return root;
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        String[] nodes = data.split(",");
        return dfs(nodes, 0, nodes.length - 1);
    }
}
