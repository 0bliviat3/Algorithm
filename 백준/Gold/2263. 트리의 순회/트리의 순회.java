import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ2263Sol().run();
    }
}

class Node2263 {
    int data;
    Node2263 left;
    Node2263 right;

    Node2263(int data) {
        this.data = data;
    }

}

class BOJ2263Sol {

    private StringBuilder preOrder;
    private int[] postOrder;
    private int[] inOrder;
    private int[] inOrderIdxs;
    private int n, postIdx;

    private void clear() {
        postOrder = new int[n];
        inOrder = new int[n];
        inOrderIdxs = new int[n + 1];
        preOrder = new StringBuilder();
    }

    private void setPostOrder(String input) {
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void setInOrder(String input) {
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderIdxs[inOrder[i]] = i;
        }
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        postIdx = n = Integer.parseInt(in.readLine());
        clear();
        setInOrder(in.readLine());
        setPostOrder(in.readLine());
    }

    private Node2263 setTree(int start, int end) {
        if(start > end) {
            return null;
        }
        if(postIdx-- == 0) {
            return null;
        }
        int data = postOrder[postIdx];
        Node2263 node = new Node2263(data);
        node.right = setTree(inOrderIdxs[data] + 1, end);
        node.left = setTree(start, inOrderIdxs[data] - 1);
        return node;
    }

    void preOrder(Node2263 root) {
        if(root == null) {
            return;
        }
        preOrder.append(root.data).append(' ');
        preOrder(root.left);
        preOrder(root.right);
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        preOrder(setTree(0, n - 1));
        System.out.print(preOrder);
    }
}