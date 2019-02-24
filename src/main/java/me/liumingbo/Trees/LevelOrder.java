package me.liumingbo.Trees;

import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> treeNodeLinkedList = new LinkedList<>();
        treeNodeLinkedList.add(root);
        TreeNode currentNode;
        while (!treeNodeLinkedList.isEmpty()) {
            currentNode = treeNodeLinkedList.poll();
            System.out.println(currentNode.val);
            if (currentNode.left != null) {
                treeNodeLinkedList.add(currentNode.left);
            }
            if (currentNode.right != null) {
                treeNodeLinkedList.add(currentNode.right);
            }
        }
    }
}
