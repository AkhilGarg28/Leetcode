/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        pre(root, list, 0, 0);
        Collections.sort(list, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int col = Integer.MIN_VALUE;
        for (int[] x : list) {
            if (x[1] != col) {
                ans.add(new ArrayList<>());
                col = x[1];
            }
            ans.get(ans.size() - 1).add(x[2]);
        }
        return ans;
    }
    static void pre(TreeNode root, List<int[]> list, int row, int col) {
        if (root == null) return;
        list.add(new int[]{row, col, root.val});
        pre(root.left, list, row + 1, col - 1);
        pre(root.right, list, row + 1, col + 1);
    }
}