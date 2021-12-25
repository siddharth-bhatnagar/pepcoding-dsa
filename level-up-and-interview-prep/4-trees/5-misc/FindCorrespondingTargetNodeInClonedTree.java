// Leetcode 1379
// O(N) time, O(H) space

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original, cloned, target);
        return targetInClone;
    }

    private TreeNode targetInClone;

    private void dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null)
            return;
        if (original == target)
            targetInClone = cloned;

        dfs(original.left, cloned.left, target);
        dfs(original.right, cloned.right, target);
    }
}

