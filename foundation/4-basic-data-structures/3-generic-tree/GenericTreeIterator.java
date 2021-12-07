import java.io.*;
import java.util.*;

public class GenericTreeIterator {

    private static class GenericTree implements Iterable<Integer> {
        Node root;

        public GenericTree(Node root) {
            this.root = root;
        }

        @Override
        public Iterator<Integer> iterator() {
            Iterator<Integer> gti = new GenericTreePreorderIterator(root);
            return gti;
        }
    }

    private static class GenericTreePreorderIterator implements Iterator<Integer> {

        Integer nval;
        Stack<Pair> stack;

        public GenericTreePreorderIterator(Node root) {
            nval = null;
            stack = new Stack<Pair>();
            stack.push(new Pair(root, -1));
            next();
        }

        @Override
        public boolean hasNext() {
            if (nval == null)
                return false;
            else
                return true;
        }

        @Override
        public Integer next() {
            Integer fv = nval;
            nval = null;
            while (stack.size() > 0) {
                Pair top = stack.peek();
                if (top.state == -1) {
                    nval = top.node.data;
                    top.state++;
                    break;
                } else if (top.state <= top.node.children.size() - 1) {
                    stack.push(new Pair(top.node.children.get(top.state), -1));
                    top.state++;
                } else {
                    stack.pop();
                }
            }

            return fv;
        }
    }

    private static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static Node constructGenericTree(int[] arr) {
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == -1) {
                stack.pop();
            } else {

                Node temp = new Node();
                temp.data = arr[i];

                if (stack.isEmpty()) {
                    root = temp;
                } else {
                    stack.peek().children.add(temp);
                }
                stack.push(temp);
            }
        }
        return root;
    }

    private static void displayGenericTree(Node node) {
        StringBuilder sb = new StringBuilder(new String(node.data + " -> "));
        for (Node child : node.children) {
            sb.append(child.data + ", ");
        }
        sb.append(".");
        System.out.println(sb);
        for (Node child : node.children) {
            displayGenericTree(child);
        }
    }

    public static void main(String[] args) { // Driver Program

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int[] treeNodesInfo = new int[n];
        // for (int i = 0; i < treeNodesInfo.length; i++) {
        // treeNodesInfo[i] = Integer.parseInt(br.readLine());
        // }
        int[] treeNodesInfo = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
                -1, -1, -1 };
        Node root = constructGenericTree(treeNodesInfo);
        // displayGenericTree(root);
        GenericTree tree = new GenericTree(root);

        for (Integer val : tree) {
            System.out.print(val + " ");
        }

        // Converts to
        /**
         * 
         * Iterator<Integer> gti = tree.iterator();
         * while(gti.hasNext() == true) {
         *  System.out.print(gti.next() + " ");
         * }
         * 
         */
    }
}
