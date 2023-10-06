import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		CallTrie trie = new CallTrie();
		while(t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] strArr = new String[n];
			for(int i = 0; i < n; i++) {
				strArr[i] = in.readLine();
			}
			Arrays.sort(strArr,new CompareAttention());
			trie.init();
			boolean flag = false;
			for(int i = 0; i < n; i++) {
				if(!trie.insert(strArr[i])) {
					flag = true;
					break;
				}
			}
			if(flag) {
				sb.append("NO\n");
			}else {
				sb.append("YES\n");
			}
				
		}
		
		System.out.print(sb);
	}

}

class CompareAttention implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o2.length() - o1.length();
	}
	
}

class CallNode {
	
	private CallNode[] child;
	
	CallNode add(char key) {
		int no = key - '0';
		if(child == null) { child = new CallNode[10]; }
		if(child[no] == null) { child[no] = new CallNode(); }
		return child[no];
	}
	
	boolean hasmoreChild() {
		return child == null;
	}
	
	
}

class CallTrie {
	
	private CallNode root;
	
	void init() {
		root = new CallNode();
	}
	
	boolean insert(String str) {
		int size = str.length();
		return insertProcess(root.add(str.charAt(0)),str,size,1);
	}
	
	private boolean insertProcess(CallNode node, String str, int size, int idx) {
		if(size == idx) { return node.hasmoreChild(); }
		return insertProcess(node.add(str.charAt(idx)),str,size,idx + 1);
	}
}
