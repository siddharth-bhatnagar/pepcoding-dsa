import java.io.*;
import java.util.*;

public class SizeSumMaxMinFindBST {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int size(Node node) {
    // write your code here
    int count = 0;
    if(node.left!=null) {
        int temp = size(node.left);
        count += temp;
    }
     if(node.right!=null) {
        int temp = size(node.right);
        count += temp;
    }
    count++;
    return count;
  }

  public static int sum(Node node) {
    // write your code here
    int sum = 0;
    if(node.left!=null){
        int temp = sum(node.left);
        sum+=temp;
    }
    if(node.right!=null){
        int temp = sum(node.right);
        sum+=temp;
    }
    return sum+node.data;
  }

  public static int max(Node node) {
    // write your code here
    if(node.right == null){
        return node.data;
    }
    else{
        int temp = max(node.right);
        return temp;
    }
  }

  public static int min(Node node) {
    // write your code here
    if(node.left == null){
        return node.data;
    }
    else{
        int temp = min(node.left);
        return temp;
    }
    
  }

  public static boolean find(Node node, int data){
    // write your code here
    if(node == null){
        return false;
    }
    if(data<node.data){
        boolean temp = find(node.left, data);
        return temp;
    }
    else if(data>node.data){
        boolean temp = find(node.right, data);
        return temp;
    }
    else{
        return true;
    }
  }  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);

    int size = size(root);
    int sum = sum(root);
    int max = max(root);
    int min = min(root);
    boolean found = find(root, data);

    System.out.println(size);
    System.out.println(sum);
    System.out.println(max);
    System.out.println(min);
    System.out.println(found);
  }

}