import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Main m = new Main();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		while (n != 0) {
			int n2 = n;
			long[] arr = new long[n];
			int[] tree = new int[n * 4];
			int i = 0;
			while (n2-- > 0) {
				arr[i++] = Long.parseLong(st.nextToken());
			}
			m.init(arr, tree, 1, 0, n - 1);
			long max = m.maxArea(arr, tree, 0, n - 1);
			sb.append(max);
			sb.append("\n");
			st = new StringTokenizer(in.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
		}
		in.close();
		System.out.print(sb);

	}

	// tree 생성
	private void init(long[] arr, int[] tree, int node, int start, int end) {
		if (start == end) {
			tree[node] = start;
		} else {
			int mid = (start + end) / 2;
			init(arr, tree, node * 2, start, mid);
			init(arr, tree, node * 2 + 1, mid + 1, end);
			if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
				tree[node] = tree[node * 2];
			} else {
				tree[node] =  tree[node * 2 + 1];
			}
		}
	}

	// 최소값 인덱스 찾기
	private int findIdx(long[] arr, int[] tree, int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return -1; // -1은 인덱스가 될수 없다
		}
		if (left <= start && right >= end) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		int m1 = findIdx(arr, tree, node * 2, start, mid, left, right);
		int m2 = findIdx(arr, tree, node * 2 + 1, mid + 1, end, left, right);
		if (m1 == -1) {
			return m2;
		} else if (m2 == -1) {
			return m1;
		} else {
			if (arr[m1] <= arr[m2]) {
				return m1;
			} else {
				return m2;
			}
		}

	}

	// 사각형 최대 넓이 찾기
	private long maxArea(long[] arr, int[] tree, int start, int end) {
		int n = arr.length;
		int m = findIdx(arr, tree, 1, 0, n - 1, start, end);
		long area = (end - start + 1) * arr[m];
		if (start <= m - 1) {
			long temp = maxArea(arr, tree, start, m - 1);
			if (area < temp) {
				area = temp;
			}
		}
		if (m + 1 <= end) {
			long temp = maxArea(arr, tree, m + 1, end);
			if (area < temp) {
				area = temp;
			}
		}
		return area;
	}

}
