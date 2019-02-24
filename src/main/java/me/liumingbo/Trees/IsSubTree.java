package me.liumingbo.Trees;

public class IsSubTree {

    public boolean isSubTree(TreeNode root1, TreeNode root2){
        boolean result = false;
        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                result = doesTree1HaveTree2(root1, root2);
            }
            if (result == false) {
                result = isSubTree(root1.left, root2);
            }
            if (result == false) {
                result = isSubTree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
