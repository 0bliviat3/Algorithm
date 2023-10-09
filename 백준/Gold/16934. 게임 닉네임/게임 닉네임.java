import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		AsTrie trie = new AsTrie();
		int n = Integer.parseInt(in.readLine());
		
		while(n-- > 0) { sb.append(trie.insert(in.readLine())).append('\n'); }
		
		in.close();
		
		System.out.print(sb);
	}

}

class AsNode {
	
	private int cnt;
	private AsNode[] child;
	
	boolean add(char val) {
		int idx = val - 'a';
		if(child == null) { child = new AsNode[26]; }
		if(child[idx] == null) { 
			child[idx] = new AsNode();
			return true;
		}
		return false;
	}
	
	AsNode getChildNode(char val) {
		return child[val - 'a'];
	}
	
	int increCnt() { return ++cnt; }
}

class AsTrie {
	
	private AsNode root;
	private StringBuilder sb;
	
	AsTrie(){
		root = new AsNode();
		sb = new StringBuilder();
	}
	
	String insert(String nickname) {
		int size = nickname.length();
		sb.setLength(0);
		return insertPro(root,nickname,size,0,true);
	}
	
	private String insertPro(AsNode node, String nickname, int size, int idx, boolean flag) {
		if(size == idx) {
			int cnt = node.increCnt();
			if(sb.length() == size && cnt > 1) { sb.append(cnt); }
			return sb.toString();
		}
		char val = nickname.charAt(idx);
		if(!node.add(val)) { 
			sb.append(val); 
		}else if(flag){
			sb.append(val);
			flag = false;
		}
		return insertPro(node.getChildNode(val),nickname,size,idx + 1,flag);
	}
}


