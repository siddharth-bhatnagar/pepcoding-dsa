
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        if (root == null)
            return new ArrayList<>();
        ;

        // stores min vl and max vl
        int[] arr = new int[2];
        // calculates min and max vl
        widthOfShadow(root, arr, 0);
        // Distance between leftmost and rightmost nodes in tree including both
        int width = arr[1] - arr[0] + 1;

        int[] result = new int[width];
        // Queue for BFS
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(root, Math.abs(arr[0])));

        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                Pair rem = queue.removeFirst();
                Node node = rem.node;
                int vl = rem.level;

                result[vl] += node.data;

                if (node.left != null) {
                    queue.addLast(new Pair(node.left, vl - 1));
                }

                if (node.right != null) {
                    queue.addLast(new Pair(node.right, vl + 1));
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int val : result)
            ans.add(val);
        return ans;
    }

    private class Pair {
        Node node;
        int level;

        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private void widthOfShadow(Node node, int[] arr, int vl) {
        if (node == null)
            return;

        arr[0] = Math.min(arr[0], vl);
        arr[1] = Math.max(arr[1], vl);

        widthOfShadow(node.left, arr, vl - 1);
        widthOfShadow(node.right, arr, vl + 1);
    }
}
