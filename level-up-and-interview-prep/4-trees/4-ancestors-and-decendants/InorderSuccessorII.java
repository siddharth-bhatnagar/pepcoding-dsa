// Definition for a Node.
/*
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        Node successor = null;
        
        if(node.right == null) {
            Node parent = node.parent;
            while(parent != null && parent.val < node.val) {
                parent = parent.parent;
            }
            successor = parent;
        }
        else {
            Node temp = node.right;
            while(temp.left != null) temp = temp.left;
            successor = temp;
        }
        
        return successor;
    }
}