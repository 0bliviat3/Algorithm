import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		Trie trie = new Trie();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			trie.insert(in.readLine());
		}
		
		for(int i = 0; i < m; i++) {
			String str = in.readLine();
			if(trie.search(str)) { cnt++; }
		}
		
		in.close();
		
		System.out.print(cnt);
	}
}

class StrNode {
	int key;
	StrNode[] child = new StrNode[26];
	
	StrNode(int key) {
		this.key = key;
	}
}


class Trie {
	StrNode root;
	
	Trie(){
		root = new StrNode(-1);
	}
	
	void insert(String str) {
		int len = str.length();
		int child = str.charAt(0) - 'a';
		if(root.child[child] == null) {
			root.child[child] = new StrNode(-1);			
		}
		setTrie(root.child[child],str,len,1,child);
	}
	
	private void setTrie(StrNode node, String str, int len, int idx, int parent) {
		if(idx == len) return;
		int child = str.charAt(idx) - 'a';
		if(node.child[child] == null) {
			node.child[child] = new StrNode(parent);			
		}
		setTrie(node.child[child], str, len, idx + 1,child);
	}
	
	boolean search(String str) {
		int len = str.length();
		if(len == 0) return false;
		return searchProcess(root,str,len,0);
	}
	
	private boolean searchProcess(StrNode node, String str, int len, int idx) {
		if(len == idx) return true;
		int key = str.charAt(idx) - 'a';
		if(node.child[key] == null) return false;
		return searchProcess(node.child[key], str, len, idx + 1);
	}
	
}