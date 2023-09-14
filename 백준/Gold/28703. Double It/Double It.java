import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 값을 우선순위큐에 저장(최소힙)
	 * 저장시 최대값 구한다
	 * remove 연산후 *2 다시 add
	 * 이때 현재 큐의 최대값을 하나의 변수에 계속 갱신해준다
	 * 저장시구한 최대값보다 현재 큐의 최소값이 커지는 시점 break
	 */
	
	static int[] queue = new int[200_001];
	static int top = 0;
	
	static void ex(int a, int b) {
		int temp = queue[a];
		queue[a] = queue[b];
		queue[b] = temp;
	}
	
	static void add(int val) {
		queue[++top] = val;
		// 루트로 최소값을 보냄
		for(int i = top; i > 1; i/=2) {
			if(queue[i / 2] > queue[i]) {
				ex(i,i/2);
			}
		}
	}
	
	static int remove() {
		int min = queue[1];
		queue[1] = queue[top];
		queue[top] = Integer.MAX_VALUE; // 노드끝값삭제
		int idx = 1;
		while(idx * 2 < top) {
			int l = idx * 2;
			int r = idx * 2 + 1;
			if(queue[idx] > queue[l] || queue[idx] > queue[r]) {
				if(queue[l] < queue[r]) {
					ex(l,idx);
					idx = l;
				}else {
					ex(r,idx);
					idx = r;
				}
			}else {
				break;
			}
		}
		top--;
		return min;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int max = 0;
		int now = 0;
		in.close();
		for(int i = 0; i < n; i++) {
			now = Integer.parseInt(st.nextToken());
			max = (max < now) ? now : max;
			add(now);
		}
		
		int nowMax = max;
		int gap = max - queue[1];
		int val = 0;
		while(queue[1] <= max) {
			val = remove();
			int nowGap = nowMax - val;
			gap = (gap > nowGap) ? nowGap : gap;
			int tw = val << 1;
			nowMax = (nowMax < tw) ? tw : nowMax;
			add(tw);
		}
		System.out.println(gap);
	}
}