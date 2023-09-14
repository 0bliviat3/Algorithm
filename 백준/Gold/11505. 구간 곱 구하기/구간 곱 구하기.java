import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private int[] arr;
	private long[] tree;
	private int mod = 1000000007;

	private Main(int n) {
		arr = new int[n];
		tree = new long[treeSize(n)];
	}

	private int treeSize(int n) {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int size = (1 << (h + 1));
		return size;
	}

	private void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			init(node * 2, start, mid);
			init(node * 2 + 1, mid + 1, end);
			tree[node] = tree[node * 2] * tree[node * 2 + 1] % mod;
		}
	}

	private long query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 1;
		}
		if (left <= start && right >= end) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		long m1 = query(node * 2, start, mid, left, right);
		long m2 = query(node * 2+1, mid + 1, end, left, right);
		return (m1 * m2) % mod;
	}

	private void updateTree(int node, int start, int end, int index, long value) {
		if (index < start || index > end) {
			return;
		}
		if(start == end) {
			tree[node] = value;
			return;
		}else {
			int mid = (start + end) / 2;
			updateTree(node * 2, start, mid, index, value);
			updateTree(node * 2 + 1, mid + 1, end, index, value);
			tree[node] = tree[node*2]*tree[node*2+1] % mod;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		m += Integer.parseInt(st.nextToken());
		Main t = new Main(n);
		for (int i = 0; i < n; i++) {
			t.arr[i] = Integer.parseInt(in.readLine());
		}
		t.init(1, 0, n - 1);
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if(a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				t.updateTree(1, 0, n-1, b-1, c);
			}else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long mul = t.query(1, 0, n-1, b-1, c-1);
				sb.append(mul+"\n");
			}
		}
		System.out.print(sb);

	}

}
