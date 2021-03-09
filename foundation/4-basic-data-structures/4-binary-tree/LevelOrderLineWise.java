import java.util.*;

public class LevelOrderLineWise {

    // TreeNode class for a node of a Binary Search Tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // This is a functional problem. You have to complete this function.
    // It takes as input the root of the given tree. It should return the
    // level order traversal as an arraylist of arraylist.
    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode node) {
        // write your code here.
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode rem = queue.removeFirst();
                temp.add(rem.val);
                if (rem.left != null) {
                    queue.addLast(rem.left);
                }
                if (rem.right != null) {
                    queue.addLast(rem.right);
                }
            }
            ans.add(temp);
        }
        return ans;

    }

    public static ArrayList<ArrayList<Integer>> levelOrderTraversalLinewie(TreeNode node) {
        // write your code here.
        Queue <TreeNode> mq = new ArrayDeque<>();
        Queue <TreeNode> cq = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        mq.add(node);
        while(mq.size()>0){
            node = mq.remove();
            temp.add(node.val);
            
            if(node.left!=null){
              cq.add(node.left);    
            }
            
            if(node.right!=null){
                cq.add(node.right);
            }
            
            if(mq.size()==0){
                mq = cq;
                cq = new ArrayDeque<>();
                ans.add(temp);
                temp = new ArrayList<>();
            }
        }
        return ans;
  }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // length of array representing the tree
        int len = sc.nextInt();

        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = levelOrder(arr);

        ArrayList<ArrayList<Integer>> res = levelOrderTraversal(root);

        for (ArrayList<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    // utility function to display a binary tree
    public static void display(TreeNode node) {
        if (node == null) {
            return;
        }

        String str = "";

        str += node.left == null ? "." : node.left.val;
        str += " <= " + node.val + " => ";
        str += node.right == null ? "." : node.right.val;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // creation of tree from array by level order, -1 says there is no node
    public static TreeNode levelOrder(int[] arr) {

        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < nodes.length; i++) {
            if (arr[i] != -1) {
                nodes[i] = new TreeNode(arr[i]);

                if (i > 0) {
                    int pi = (i - 1) / 2;

                    if (i == 2 * pi + 1) {
                        nodes[pi].left = nodes[i];
                    } else {
                        nodes[pi].right = nodes[i];
                    }
                }
            }
        }

        TreeNode root = nodes[0];
        return root;
    }

}