import java.io.*;
import java.util.*;

// diameter --> distance between two farthest nodes in terms of edge count
// startegy --> find max height and second max height for each node, diameter will be sum of the two + 2

public class Diameter {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        dia = 0;
        solve(root);
        System.out.println(dia);
    }

    private static int dia;

    private static int solve(Node node) {
        int lch = -1;
        int slch = -1;
        for (Node child : node.children) {
            int ch = solve(child);
            if (ch > lch) {
                slch = lch;
                lch = ch;
            } else if (ch > slch) {
                slch = ch;
            }
        }

        int cand = lch + slch + 2;
        dia = Math.max(dia, cand);

        return lch + 1;
    }
}