import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		MaxHeapImpl mhi = new MaxHeapImpl(n);
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			int now = Integer.parseInt(in.readLine());
			if (now == 0) {
				if (mhi.endIdx == 0) {
					sb.append(0 + "\n");
				} else {
					sb.append(mhi.remove() + "\n");
				}
			} else {
				mhi.add(now);
			}
		}
		in.close();
		System.out.print(sb);
	}

}

/**
 * 
 * @author jaewan song
 * @category algorithm
 * @version 1.0 최대 힙의 배열 구현
 *
 */
class MaxHeapImpl {
	private int[] heap;
	int endIdx = 0; // 0번째 인덱스는 사용하지 않는다.

	/**
	 * constructor
	 * 
	 * @param n : 힙의 크기를 인자값으로 받는다.
	 */
	MaxHeapImpl(int n) {
		heap = new int[n + 1]; // 0번째 인덱스는 사용하지 않으므로 n까지 사용하기 위함
	}

	// add
	/**
	 * 값 추가
	 * 
	 * @param val : 추가하려는 값을 인자값으로 받음
	 */
	public void add(int val) {
		heap[++endIdx] = val; // 힙의 마지막 노드에 값을 추가한다
		for (int i = endIdx; i > 1; i /= 2) {
			if (heap[i / 2] < heap[i]) { // 최대값을 루트로 보낸다.
				exchange(i / 2, i, heap[i / 2], heap[i]);
			}
		}
	}

	/**
	 * 값 교환 method
	 * 
	 * @param to      : 상위노드 혹은 루트 인덱스
	 * @param from    : 하위노드 인덱스
	 * @param toVal   : 상위노드 혹은 루트
	 * @param fromVal : 하위 노드
	 */
	private void exchange(int to, int from, int toVal, int fromVal) {
		heap[to] = fromVal;
		heap[from] = toVal;
	}

	// remove
	/**
	 * 루트 삭제후 재정렬
	 * 
	 * @return 루트를 리턴함
	 */
	public int remove() {
		int del = heap[1];
		heap[1] = heap[endIdx];
		heap[endIdx] = 0; // 최하위 노드 삭제
		int now = 1;
		while (now * 2 < endIdx) {
			int left = now * 2;
			int right = now * 2 + 1;
			if (heap[now] < heap[left] || heap[now] < heap[right]) {
				if (heap[left] >= heap[right]) {
					exchange(now, left, heap[now], heap[left]);
					now = left;
				} else {
					exchange(now, right, heap[now], heap[right]);
					now = right;
				}
			} else {
				break;
			}
		}
		endIdx--;
		return del;
	}
}