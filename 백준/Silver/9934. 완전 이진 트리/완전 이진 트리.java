import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int idx,size;
	static String[] queue;
	static ArrayList<String>[] tree;
	
	static void inOrder(int node,int depth) {
		if(node >= size) return;
		inOrder(node * 2,depth + 1);
		tree[depth].add(queue[idx++]);
		inOrder(node * 2 + 1,depth + 1);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(in.readLine());
		queue = in.readLine().split(" ");
		
		in.close();
		
		size = (int) Math.pow(2, k);
		
		tree = new ArrayList[k];

		for(int i = 0; i < k; i++) {
			tree[i] = new ArrayList<>();
		}
		
		inOrder(1,0);
		
		for(int i = 0; i < k; i++) {
			for(String node : tree[i]) {
				sb.append(node).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	
}
