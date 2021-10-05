import java.io.*;
import java.util.*;

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
        mh = -1;
        smh = -1;
        int ans = diameter(root);
        System.out.println(ans);
    }

    private static int mh, smh;
    public static int diameter(Node root) {
        for(Node child: root.children) {
            int h = helper(child);
            if(h > mh) {
                mh = h;
            }else if(h > smh) {
                smh = h;
            }
        }

        return mh + smh + 2;    
    }

    private static int helper(Node node) {
        int h=-1;
        for(Node child: node.children) {
            int temp = helper(child);
            h = Math.max(temp, h);
        }
        h+=1;
        return h;
    }

}