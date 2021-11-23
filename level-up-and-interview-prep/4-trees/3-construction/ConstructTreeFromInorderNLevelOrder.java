// GFG

// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}

class ConstructBT {
    Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int inord[] = new int[n];
            int level[] = new int[n];
            for (int i = 0; i < n; i++)
                inord[i] = sc.nextInt();

            for (int i = 0; i < n; i++)
                level[i] = sc.nextInt();

            GfG g = new GfG();
            Node node = g.buildTree(inord, level);
            printPreOrder(node);
            System.out.println();

        }
    }

    static void printPreOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
// } Driver Code Ends

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

/* Complete the function below */
class GfG {
    Node buildTree(int inord[], int level[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= inord.length - 1; i++) {
            map.put(inord[i], i);
        }

        return construct(inord, level, map, 0, inord.length - 1);
    }

    Node construct(int[] in, int[] level, HashMap<Integer, Integer> map, int is, int ie) {
        if (is > ie) {
            return null;
        }

        Node root = new Node(level[0]);
        int idx = map.get(level[0]);

        int llos = idx - is;
        int rlos = ie - idx;

        int[] llo = new int[llos];
        int[] rlo = new int[rlos];
        int j = 0, k = 0;
        for (int i = 1; i < level.length; i++) {
            if (map.get(level[i]) < idx) {
                llo[j] = level[i];
                j++;
            } else if (map.get(level[i]) > idx) {
                rlo[k] = level[i];
                k++;
            } else {
                continue;
            }
        }

        root.left = construct(in, llo, map, is, idx - 1);
        root.right = construct(in, rlo, map, idx + 1, ie);

        return root;
    }
}