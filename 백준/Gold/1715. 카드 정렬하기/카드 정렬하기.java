import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] heap = new int[100_001];
	static int top = 0;

	static void exchange(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}

	static void add(int val) {
		heap[++top] = val;
		for (int i = top; i > 1; i /= 2) {
			if (heap[i / 2] > heap[i]) {
				exchange(i / 2, i);
			}
		}
	}

	static int del() {
		int del = heap[1];
		heap[1] = heap[top];
		heap[top] = Integer.MAX_VALUE;
		int now = 1;
		while (now * 2 < top) {
			int left = now * 2;
			int right = now * 2 + 1;
			if (heap[now] > heap[left] || heap[now] > heap[right]) {
				if (heap[left] < heap[right]) {
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
		while (n-- > 0) {
			add(Integer.parseInt(in.readLine()));
		}
		in.close();

		int sum = 0;
		int val = 0;
		while (top > 0) {
			val = del();
			if (top == 0)
				break;
			val += del();
			sum += val;
			add(val);
		}
		System.out.print(sum);
	}
}