import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * union-find
	 * 연결관계를 입력받아 union
	 * 각 집합의 루트노드 두개 출력
	 */

	public static void main(String[] args) {
		new BOJ17352Sol().run();
	}

}

class BOJ17352Sol {
	
	private int[] parent;
	
	private void clear(int n) {
		parent = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	private int getParent(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = getParent(parent[x]);
	}
	
	private void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a < b) {
			parent[b] = a;
			return;
		}
		parent[a] = b;
	}
	
	private void printAns(int n) {
		int a = getParent(1);
		int b = 0;
		for(int i = 2; i <= n; i++) {
			if(a != (b = getParent(i))) {
				break;
			}
		}
		System.out.print(a + " " + b);
	}
	
	private void process() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		clear(n);
		int bridge = n - 2;
		while(bridge-- > 0) {
			unionBridge(in.readLine());
		}
		printAns(n);
	}
	
	private void unionBridge(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		union(a, b);
	}
	
	void run() {
		try {
			process();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}