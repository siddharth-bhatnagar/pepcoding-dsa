/**
 * Definition for Node.
 * public class Node {
 * int val;
 * Node left;
 * Node right;
 * Node random;
 * Node() {}
 * Node(int val) { this.val = val; }
 * Node(int val, Node left, Node right, Node random) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * this.random = random;
 * }
 * }
 */

// Leetcode 1485
// HashMap Solution
class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {

        HashMap<Node, NodeCopy> map = new HashMap<>();
        NodeCopy clonedRoot = clone(root, map);

        if (map.size() != 0)
            setRandom(map);

        return clonedRoot;
    }

    private NodeCopy clone(Node root, HashMap<Node, NodeCopy> map) {
        if (root == null)
            return null;
        NodeCopy node = new NodeCopy(root.val);
        map.put(root, node);

        node.left = clone(root.left, map);
        node.right = clone(root.right, map);

        return node;
    }

    private void setRandom(HashMap<Node, NodeCopy> map) {
        for (Node node : map.keySet()) {
            NodeCopy clonedNode = map.get(node);
            Node originalRandom = node.random;
            if (originalRandom != null) {
                NodeCopy clonedRandom = map.get(originalRandom);
                clonedNode.random = clonedRandom;
            }
        }
    }
}

// Without HashMap, GFG
class Solution{
    public Tree cloneTree(Tree tree) {
        if(tree == null) return null;
        
        tranformToLeftClonedTree(tree);
        setRandom(tree);
        Tree clonedTree = extractAndTransformBack(tree);
        
        return clonedTree;
    }
    
    private void tranformToLeftClonedTree(Tree root) {
        if(root == null) return;
        
        Tree node = new Tree(root.data);
        node.left = root.left;
        root.left = node;
        
        tranformToLeftClonedTree(root.left.left);
        tranformToLeftClonedTree(root.right);
    }
    
    private void setRandom(Tree root) {
        if(root == null) return;
        
        if(root.random != null)
            root.left.random = root.random.left;
        
        setRandom(root.left.left);
        setRandom(root.right);
    }
    
    private Tree extractAndTransformBack(Tree root) {
        if(root == null) return null;
        
        Tree left = extractAndTransformBack(root.left.left);
        Tree right = extractAndTransformBack(root.right);
        
        Tree temp = root.left;
        root.left = root.left.left;
        
        temp.left = left;
        temp.right = right;
        
        return temp;
    }
}