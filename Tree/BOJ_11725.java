import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = Integer.parseInt(br.readLine());
        
        Tree tree = new Tree();
        
        for (int i = 0; i < cnt - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree.insert(tree.root, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));        }
        
        for (int i = 2; i <= cnt; i++) {
            tree.printParent(tree.root, i);
        }
    }
}

class Node {
    public int data;
    public ArrayList<Node> next;
    
    public Node(int data) {
        this.data = data;
        next = new ArrayList();
    }
}

class Tree {
    public Node root;
    
    public void insert(Node node, int a, int b) {
        if (root == null) {
            root = new Node(a);
            root.next.add(new Node(b));
            return;
        }
        
        if (node == null) {
            return;
        }
        
        if (node.data == a) {
            node.next.add(new Node(b));
            return;
        } else if (node.data == b) {
            node.next.add(new Node(a));
            return;
        }
        
        for (Node n : node.next) {
            insert(n, a, b);
        }
    }
    
    public void printParent(Node node, int data) {
        if (node == null) {
            return;
        }
        
        for (Node n : node.next) {
            if (n.data == data) {
                System.out.println(node.data);
            } else {
                printParent(n, data);
            }
        }
    }
}