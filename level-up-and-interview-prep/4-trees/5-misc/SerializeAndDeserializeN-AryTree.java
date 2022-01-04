/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// Leetcode 428
class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
    
    private void serialize(Node node, StringBuilder sb) {
        sb.append(node.val + " ");
        for(Node child: node.children) {
            serialize(child, sb);
        }
        sb.append("-1 ");
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0) return null;
        String[] arr = data.split(" ");
        
        Stack<Node> stack = new Stack<>();
        Node root = new Node(Integer.parseInt(arr[0]), new ArrayList<Node>());
        stack.push(root);
        
        for(int i=1;i<arr.length;i++) {
            if(arr[i].equals("-1")) {
                stack.pop();
            }
            else {
                Node child = new Node(Integer.parseInt(arr[i]), new ArrayList<Node>());
                stack.peek().children.add(child);
                stack.push(child);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));