import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private Node root;
	private StringBuilder sb = new StringBuilder();
	
	public void init(char data, char left, char right) {
		if(data == 'A') {
			root = new Node(data);
			if(left != '.') root.left = new Node(left);
			if(right != '.') root.right = new Node(right);
		}else {
			search(root, data, left, right);
		}
	}
	
	private void search(Node node, char data, char left, char right) {
		if(node == null) return;
		if(node.data == data) {
			if(left != '.') node.left = new Node(left);
			if(right != '.') node.right = new Node(right);
		}else {
			search(node.left,data,left,right);
			search(node.right,data,left,right);
		}
	}
	
	private void preOrder(Node node) {
		if(node == null) return;
		sb.append(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	private void inOrder(Node node) {
		if(node == null) return;
		inOrder(node.left);
		sb.append(node.data);
		inOrder(node.right);
	}
	
	private void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.data);
	}
	
	public void prt() {
		preOrder(root);
		sb.append('\n');
		inOrder(root);
		sb.append('\n');
		postOrder(root);
		System.out.print(sb);
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main tree = new Main();
		int n = Integer.parseInt(in.readLine());
		char[] data;
		while(n-- > 0) {
			data = in.readLine().toCharArray();
			tree.init(data[0], data[2], data[4]);
		}
		
		in.close();
		
		tree.prt();
	}
	
}

class Node {
	
	char data;
	Node left;
	Node right;
	
	Node(char data){
		this.data = data;
	}
}