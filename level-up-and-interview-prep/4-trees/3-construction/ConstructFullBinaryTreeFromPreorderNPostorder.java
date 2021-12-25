class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return construct(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private HashMap<Integer, Integer> map;

    private TreeNode construct(int[] pre, int[] post, int ps, int pe, int pps, int ppe) {
        if (ps > pe)
            return null;
        if (ps == pe) {
            return new TreeNode(pre[ps]);
        }

        int val = pre[ps];
        TreeNode node = new TreeNode(val);
        int idx = map.get(pre[ps + 1]);
        int count = idx - pps;

        node.left = construct(pre, post, ps + 1, ps + count + 1, pps, idx);
        node.right = construct(pre, post, ps + count + 2, pe, idx + 1, ppe - 1);

        return node;
    }
}

// O(N) time, O(N+H) space 