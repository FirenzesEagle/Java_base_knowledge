package me.liumingbo.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {

    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int sum) {
        if (root == null) {
            return resultList;
        }
        path.add(root.val);
        findPath(root, sum);
        return resultList;
    }

    private List<List<Integer>> findPath(TreeNode root, int sum) {
        if (root == null) {
            return resultList;
        }
        path.add(root.val);
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            findPath(root.left, sum);
        }
        if (root.right != null) {
            findPath(root.right, sum);
        }
        path.remove(path.size() - 1);
        return resultList;
    }

}
