import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BOJ5639Sol instance = new BOJ5639Sol();
		instance.run();
	}

}

class BOJ5639Node {
	
	final int data;
	BOJ5639Node left;
	BOJ5639Node right;
	
	BOJ5639Node(final int data) {
		this.data = data;
	}
	
	boolean isLeftEmpty() {
		return left == null;
	}
	
	boolean isRightEmpty() {
		return right == null;
	}
	
}

class BOJ5639Tree {
	
	private final BOJ5639Node root;
	
	BOJ5639Tree(final BOJ5639Node root) {
		this.root = root;
	}
	
	void insert(int data) {
		insert(data, root);
	}
	
	private void insert(int data, BOJ5639Node node) {
		if(node.data > data) {
			if(node.isLeftEmpty()) {
				node.left = new BOJ5639Node(data);
				return;
			}
			insert(data, node.left);
			return;
		}
		if(node.isRightEmpty()) {
			node.right = new BOJ5639Node(data);
			return;
		}
		insert(data, node.right);
	}
	
	String postOrder() {
		StringBuilder sb = new StringBuilder();
		postOrder(root, sb);
		return sb.toString();
	}
	
	private void postOrder(BOJ5639Node node, StringBuilder sb) {
		if(node != null) {
			postOrder(node.left, sb);
			postOrder(node.right, sb);
			sb.append(node.data).append('\n');			
		}
	}
}

class BOJ5639Sol {
	
	private BOJ5639Tree tree;
	
	void run() {
		try {
			init();
			prtPostOrder();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		tree = new BOJ5639Tree(new BOJ5639Node(Integer.parseInt(in.readLine())));
		String next = null;
		while((next = in.readLine()) != null && !next.isEmpty()) {
			tree.insert(Integer.parseInt(next));
		}
	}
	
	private void prtPostOrder() {
		System.out.print(tree.postOrder());
	}
	
}
