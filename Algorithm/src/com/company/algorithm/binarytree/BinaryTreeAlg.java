package com.company.algorithm.binarytree;

import java.util.*;

// binary tee
public class BinaryTreeAlg {
    public static void main(String[] args) {
        Integer[] tree = {3,4,20,6, null,null,15};
        TreeNode<Integer> root = treeBuilder(tree);
//        printTree(root);
        List<List<Integer>> list = levelOrder(root);
        System.out.println(Arrays.toString(list.toArray()));
    }

    // 层序遍历构建树
    public static TreeNode treeBuilder(Integer[] tree) {
        if (tree == null || tree.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(tree[index++]);
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                if (index == tree.length) {
                    queue.clear();
                    break;
                }

                TreeNode<Integer> node = queue.poll();
                if (node == null) {
                    continue;
                }
                node.left = tree[index] == null? null : new TreeNode(tree[index]);
                queue.offer(node.left);
                index++;

                node.right = tree[index] == null? null : new TreeNode(tree[index]);
                queue.offer(node.right);
                index++;
            }
        }

        return root;
    }
    public static TreeNode buildTree(Integer[] tree, int start) {
        if (tree == null || tree.length == 0 || start >= tree.length) {
            return null;
        }
        TreeNode root = new TreeNode(tree[start]);
        root.left = buildTree(tree, 2 * start + 1);
        root.right = buildTree(tree, 2 * start + 2);
        return root;
    }
    public static void printTree(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();

        nodes.add(root);
        while (nodes.size() > 0) {
            TreeNode<Integer> node = nodes.remove(0);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
            list.add(node.val);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 题目： 二叉树的最大深度
     * 输入： [3,4,20,null,null,15,7]
     * 输出： 3
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {  //非递归
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }

        }

        return depth;
    }
    //递归
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    /**
     * 题目： 给定一个二叉树，返回其按层次遍历的节点值。（即逐层地，从左到右访问所有节点）。
     * 输入： 二叉树[3,9,20,null,null,15,7]
     * 输出： [[3],[9,20],[15,7]]
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

}

class TreeNode<T>{
    public T val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T val) {
        this.val = val;
    }
}