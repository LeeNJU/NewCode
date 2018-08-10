package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import Util.TreeNode;
import javafx.util.Pair;

//题目描述:给定一个二叉树，求出它的垂直遍历，例如二叉树为[3,9,20,4,5,2,7]，那么垂直遍历为[[4],[9],[3, 5, 2],[20],[7]]
//解法描述:根节点的col比左子节点的col大1，比右子节点的col小1，进行层次遍历，更新每个点的col，并且用map存储每个col的节点
public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        queue.add(new Pair<TreeNode, Integer>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            int column = pair.getValue();

            if (pair.getKey().left != null) {
                queue.add(new Pair<TreeNode, Integer>(root.left, column - 1));
            }

            if (pair.getKey().right != null) {
                queue.add(new Pair<TreeNode, Integer>(root.right, column + 1));
            }

            List<Integer> list = map.getOrDefault(column, new ArrayList<Integer>());
            list.add(pair.getKey().val);

            map.putIfAbsent(column, new ArrayList<>(list));
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        map.entrySet()
                .stream()
                .forEach(set -> {
                    List<Integer> list = set.getValue();
                    Collections.sort(list);
                    result.add(list);
                });

        return result;
    }
}
