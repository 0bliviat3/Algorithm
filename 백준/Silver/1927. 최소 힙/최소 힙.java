import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		MinHeapImpl mhi = new MinHeapImpl(n); // 0 은 안쓴다
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			int now = Integer.parseInt(in.readLine());
			if (now == 0) {
				if (mhi.end == 0) {
					sb.append(0 + "\n");
				} else {
					sb.append(mhi.remove() + "\n");
				}
			} else {
				mhi.add(now - 1);
			}
		}
		in.close();
		System.out.print(sb);
	}
}

class MinHeapImpl {
	int[] heap;
	int end = 0;

	MinHeapImpl(int n) {
		heap = new int[n + 1000];
	}

	// add
	public void add(int val) { // 0이 아닌경우 받은값 - 1을 인자값으로..
		heap[++end] = val;
		int idx = end;
		while (idx > 1 && heap[idx / 2] > heap[idx]) {
			exchange(idx / 2, idx, heap[idx / 2], heap[idx]);
			idx /= 2;
		}
	}

	private void exchange(int to, int from, int a, int b) {
		heap[to] = b;
		heap[from] = a;
	}

	// remove
	public int remove() {
		if (heap[1] == Integer.MAX_VALUE) return 0;
		int min = heap[1];
		heap[1] = heap[end];
		heap[end--] = Integer.MAX_VALUE;
		int now = 1;
		while (now * 2 <= end) {
			int left = now * 2;
			int right = now * 2 + 1;
			if(heap[now] > heap[left] || heap[now] > heap[right]) {
				if(heap[left] <= heap[right]) {
					exchange(now, left, heap[now], heap[left]);
					now = left;
				}else {
					exchange(now,right, heap[now], heap[right]);
					now = right;
				}
			}else {
				break;
			}
			
		}
		return min + 1;
	}
}