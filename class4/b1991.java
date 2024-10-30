/*
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Node> nodes = new ArrayList<>();
        Tree tree = new Tree(n);
        for(int i = 0; i < n; i++) {
            nodes.add(new Node((char)(65 + i)));
        }

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 65;
            int left = st.nextToken().charAt(0) - 65;
            int right = st.nextToken().charAt(0) - 65;

            if(left >= 0) {
                Node leftNode = nodes.get(left);
                leftNode.setParent(nodes.get(parent));
                nodes.get(parent).left = leftNode;
            }

            if(right >= 0) {
                Node rightNode = nodes.get(right);
                rightNode.setParent(nodes.get(parent));
                nodes.get(parent).right = rightNode;
            }
        }

        tree.addNodes(nodes);

        tree.prefix();
        tree.infix();
        tree.postfix();
    }

    public static class Tree {
        List<List<Node>> nodes = new ArrayList<>();

        Tree(int n) {
            while (n-- > 0) {
                nodes.add(new ArrayList<>());
            }
        }

        public void addNodes(List<Node> n) {
            for(Node node : n) {
                nodes.get(node.depth).add(node);
            }
        }

        public void prefix() {
            System.out.println(prefixInterval(nodes.get(0).get(0)));
        }

        public void infix() {
            System.out.println(infixInterval(nodes.get(0).get(0)));
        }

        public void postfix() {
            System.out.println(postfixInterval(nodes.get(0).get(0)));
        }

        private String prefixInterval(Node node) {
            if(node == null) return "";
            return node.alphabet + prefixInterval(node.left) + prefixInterval(node.right);
        }

        private String infixInterval(Node node) {
            if(node == null) return "";
            return infixInterval(node.left) + node.alphabet + infixInterval(node.right);
        }

        private String postfixInterval(Node node) {
            if(node == null) return "";
            return postfixInterval(node.left) + postfixInterval(node.right) + node.alphabet;
        }
    }

    public static class Node {
        Node parent;
        Node left;
        Node right;
        int depth = 0;
        char alphabet;

        Node(char alphabet) {
            this.alphabet = alphabet;
        }

        Node(char alphabet, Node parent) {
            this.alphabet = alphabet;
            this.parent = parent;
        }

        Node(char alphabet, Node left, Node right) {
            this.alphabet = alphabet;
            this.left = left;
            this.right = right;
        }

        public void setParent(Node n) {
            this.parent = n;
            this.depth = n.depth + 1;
        }

        public String toString() {
            return "" + this.alphabet;
        }
    }
}
 */