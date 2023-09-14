import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] heap = new int[500001];
	static int top = 0;

	static void add(int val) {
		heap[++top] = val;
		for (int i = top; i > 1; i /= 2) {
			if (heap[i / 2] < heap[i]) {
				exchange(i / 2, i);
			}
		}
	}

	static void exchange(int to, int from) {
		int temp = heap[to];
		heap[to] = heap[from];
		heap[from] = temp;
	}

	static int remove() {
		int del = heap[1];
		heap[1] = heap[top];
		heap[top] = 0;
		int now = 1;
		while (now * 2 < top) {
			int left = now * 2;
			int right = now * 2 + 1;
			if (heap[now] < heap[left] || heap[now] < heap[right]) {
				if (heap[left] > heap[right]) {
					exchange(left, now);
					now = left;
				} else {
					exchange(right, now);
					now = right;
				}
			} else {
				break;
			}
		}
		top--;
		return del;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (n-- > 0) {
			String a = in.readLine();
			if (a.equals("0")) {
				if (top == 0) {
					sb.append("-1\n");
				} else {
					sb.append(remove() + "\n");
				}
			} else {
				st = new StringTokenizer(a, " ");
				int aCnt = Integer.parseInt(st.nextToken());
				while (aCnt-- > 0) {
					add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		in.close();
		System.out.print(sb);
	}

}
