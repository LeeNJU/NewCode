package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树，序列化成一个字符串，然后根据字符串反序列化成一个二叉搜索树
//解法描述:利用先序遍历进行序列化，再递归反序列化

public class SerializeandDeserializeBinaryTree {

    private static final String spliter = ",";
    private static final String NN = "X";

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN)
                    .append(spliter);
        } else {
            sb.append(node.val)
                    .append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        buildString(root, stringBuilder);
        return stringBuilder.toString();
    }

    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals(NN)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>();
        Arrays.stream(data.split(spliter))
                .forEach(str -> queue.add(str));
        return buildTree(queue);
    }
}
