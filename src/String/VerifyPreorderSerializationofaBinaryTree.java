package String;

//题目描述:给定一个二叉树的前序遍历，判断是不是正确的前序遍历，例如"1,#"，返回false，例如"9,#,#,1"返回false
//解法描述:用前序遍历序列化的一般方法进行递归，index表示当前指向哪一个节点

public class VerifyPreorderSerializationofaBinaryTree {

    private int index = 0;

    private boolean dfs(String[] preorder) {
        // index 超过节点
        if (index >= preorder.length) {
            return false;
        }

        if (preorder[index++].equals("#")) {
            return true;
        }

        return dfs(preorder) && dfs(preorder);
    }

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        // 注意这里，最后的index一定等于节点个数
        return dfs(nodes) && index == nodes.length;
    }
}
