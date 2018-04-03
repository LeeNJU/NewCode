package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Util.TreeNode;

//题目描述:给定一个二叉树，打印该二叉树，例如
//         1     打印 ["", "1", ""]
//        /           ["2", "", ""]
//      2

//解法描述: 二维数组的长就是树的高度，宽就是 2^height - 1,因要考虑到二叉树是满二叉树的情况，然后递归设置二维数组，用左右下标限定数组的范围

public class PrintBinaryTree {

    private void dfs(TreeNode root, List<List<String>> result, int row, int totalRows, int i, int j) {
        if (row == totalRows || root == null) {
            return;
        }

        int col = (i + j) / 2;
        result.get(row)
                .set(col, Integer.toString(root.val));

        dfs(root.left, result, row + 1, totalRows, i, col - 1);
        dfs(root.right, result, row + 1, totalRows, col + 1, j);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new LinkedList<>();
        int height = root == null ? 1 : getHeight(root);
        int rows = height, columns = (int) (Math.pow(2, height) - 1);

        List<String> row = new ArrayList<>();
        for (int i = 0; i < columns; i++) {
            row.add("");
        }
        for (int i = 0; i < rows; i++) {
            result.add(new ArrayList<>(row));
        }

        dfs(root, result, 0, rows, 0, columns - 1);
        return result;
    }
}
