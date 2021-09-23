package cn.jothew.algorithm.tree;

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode left = root.left;
        while (left != null) {
            level++;
            left = left.left;
        }
        int low = 1 << level;
        int high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exist(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exist(TreeNode root, int level, int k) {
        TreeNode node = root;
        while (node != null && level > 0) {
            if (((k >> (level - 1)) & 1) == 1) {
                node = node.right;
            } else {
                node = node.left;
            }
            level--;
        }
        return node != null;
    }
}