import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		AntTrie trie = new AntTrie();
		int n = Integer.parseInt(in.readLine());
		while(n-- > 0) {
			trie.insert(in.readLine());
		}
		
		in.close();
		
		System.out.print(trie.preOrder());
	}

}

class AntFood {
	
	private TreeMap<String, AntFood> child;
	
	AntFood add(String food) {
		if(child == null) { child = new TreeMap<>(); }
		if(!child.containsKey(food)) { child.put(food, new AntFood()); }
		return child.get(food);
	}
	
	TreeMap<String, AntFood> getChild() { return child; }
}

class AntTrie {
	
	private AntFood root;
	private StringTokenizer st;
	private StringBuilder sb;
	
	AntTrie(){
		root = new AntFood();
		sb = new StringBuilder();
	}
	
	void insert(String text) {
		st = new StringTokenizer(text," ");
		int k = Integer.parseInt(st.nextToken());
		insertPro(root, k);
	}
	
	private void insertPro(AntFood node, int k) {
		if(k == 0) return;
		insertPro(node.add(st.nextToken()),k - 1);
	}
	
	String preOrder() {
		preOrderPro(root,0);
		return sb.toString();
	}
	
	private void preOrderPro(AntFood node, int depth) {
		TreeMap<String, AntFood> child = node.getChild();
		if(child == null) { return; }
		for(String key : child.keySet()) {
			for(int i = 0; i < depth; i++) { sb.append('-').append('-'); }
			sb.append(key).append('\n');
			preOrderPro(child.get(key),depth + 1);
		}
	}
}
