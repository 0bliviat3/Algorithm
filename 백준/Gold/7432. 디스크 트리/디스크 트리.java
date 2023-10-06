import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DirectoryTrie trie = new DirectoryTrie();
		int n = Integer.parseInt(in.readLine());
		
		while(n-- > 0) {
			trie.insert(in.readLine());
		}
		
		in.close();
		
		System.out.print(trie.preOrder());
	}

}

class Directory {
	
	private TreeMap<String,Directory> child;
	
	Directory add(String name) {
		if(child == null) { child = new TreeMap<>(); }
		if(!child.containsKey(name)) { child.put(name, new Directory()); }
		return child.get(name);
	}
	
	TreeMap<String,Directory> getChild() { return child; }
	
}

class DirectoryTrie {
	
	private Directory root;
	private StringTokenizer st;
	
	DirectoryTrie(){ root = new Directory(); }
	
	void insert(String text) {
		st = new StringTokenizer(text,"\\");
		insertProcess(root.add(st.nextToken()));
	}
	
	private void insertProcess(Directory node) {
		if(!st.hasMoreTokens()) return;
		insertProcess(node.add(st.nextToken()));
	}
	
	String preOrder() {
		StringBuilder sb = new StringBuilder();
		preOrderProcess(root,sb,0);
		return sb.toString();
	}
	
	private void preOrderProcess(Directory node, StringBuilder sb,int depth) {
		TreeMap<String,Directory> child = node.getChild();
		if(child == null) { return; }
		child.keySet().forEach(k -> {
			for(int i = 0; i < depth; i++) {
				sb.append(' ');
			}
			sb.append(k).append('\n');
			preOrderProcess(child.get(k),sb,depth + 1);
		});
		
	}
	
	
}
