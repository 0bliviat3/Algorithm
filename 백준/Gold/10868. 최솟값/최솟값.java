import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Main t = new Main();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		long[] tree = new long[t.treeSize(n)];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(in.readLine());
		}
		t.init(arr, tree, 1, 0, n - 1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long min = t.query(tree, 1, 0, n-1, a-1, b-1);
			sb.append(min + "\n");
		}
		System.out.print(sb);
	}

	private int treeSize(int n) {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int size = 1 << (h + 1);
		return size;
	}

	private void init(long[] arr, long[] tree, int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			init(arr, tree, node * 2, start, mid);
			init(arr, tree, node * 2 + 1, mid + 1, end);
			tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
		}
	}

	private long query(long[] tree, int node, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return 1000000001;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		long leftMin = query(tree, node * 2, start, mid, left, right);
		long rightMin = query(tree, node * 2 + 1, mid + 1, end, left, right);
		if(leftMin<=rightMin) {
			return leftMin;
		}else {
			return rightMin;
		}
	}

}
