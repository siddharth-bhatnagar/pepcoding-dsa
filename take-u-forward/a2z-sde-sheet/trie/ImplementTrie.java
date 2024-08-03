public class ImplementTrie {

    private class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        public Node() {

        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node ref) {
            links[ch - 'a'] = ref;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }

    }

    public class Trie {
        private Node root;
        public Trie() {
            root = new Node();
        }

        public void insert(String s) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!node.containsKey(ch)) {
                    Node refNode = new Node();
                    node.put(ch, refNode);
                }
                node = node.get(ch);
            }

            node.setEnd();
        }

        public boolean search(String s) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
            }

            return node.isEnd();
        }

        public boolean prefix(String s) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
            }

            return true;
        }
    }
}