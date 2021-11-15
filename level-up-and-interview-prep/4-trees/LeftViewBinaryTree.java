// level order -- , first node of each level
// GFG

// BFS
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> lsv = new ArrayList<>();
        if(root == null) return lsv;
        
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        
        while(queue.size() > 0) {
            int size = queue.size();
            boolean firstTime = true;
            while(size-- > 0) {
                Node node = queue.removeFirst();
                
                if(firstTime) {
                    lsv.add(node.data);
                    firstTime = false;
                }
                
                if(node.left != null) {
                    queue.addLast(node.left);
                }
                
                if(node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return lsv;
    }
}


// DFS
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> lsv = new ArrayList<>();
        leftSideView(root, lsv, 0);
        return lsv;
    }
    
    void leftSideView(Node curr, ArrayList<Integer> lsv, int currDepth) {
        if(curr == null) return;
        if(currDepth == lsv.size()) lsv.add(curr.data);
        
        leftSideView(curr.left, lsv, currDepth+1);
        leftSideView(curr.right, lsv, currDepth+1);
    }
}