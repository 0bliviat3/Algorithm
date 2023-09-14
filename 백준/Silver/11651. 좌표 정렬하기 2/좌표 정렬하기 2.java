import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[] arr = null; // 병합정렬한 x값 저장할 배열
	private int[] arrY = null;

	Main(int n) {
		arr = new int[n];
		arrY = new int[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(in.readLine());
		int[] x = new int[n];
		int[] y = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		in.close();

		StringBuilder sb = new StringBuilder();

		Main m = new Main(n);
		m.mySort(x, y, 0, n - 1);
		for (int i = 0; i < n; i++) {
			sb.append(x[i] + " " + y[i] + "\n");
		}

		System.out.print(sb);

	}

	private void mySort(int[] x, int[] y, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = (left + right) / 2;

		mySort(x, y, left, mid);
		mySort(x, y, mid + 1, right);

		merge(x, y, left, mid, right);
	}

	private void merge(int[] x, int[] y, int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;

		while ((l <= mid) || (r <= right)) {
			if (r > right || (y[l] == y[r] && x[l] < x[r]) || (l <= mid && y[l] < y[r])) {
				arrY[idx] = y[l];
				arr[idx++] = x[l++];
			} else {
				arrY[idx] = y[r];
				arr[idx++] = x[r++];
			}
		}

		for (int i = left; i <= right; i++) {
			x[i] = arr[i];
			y[i] = arrY[i];

		}
	}

}
