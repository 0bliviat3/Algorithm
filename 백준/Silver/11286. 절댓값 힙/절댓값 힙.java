import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static Integer[] heap = new Integer[100_001];
	static int node = 0;
	
	static void ex(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;

	}
	
	static void add(int val) {
		heap[++node] = val;
		for(int i = node; i > 1; i/=2) {
			if(Math.abs(heap[i/2]) > Math.abs(heap[i])) { // 최소값이 루트로
				ex(i/2,i);
			}else if(Math.abs(heap[i/2]) == Math.abs(heap[i]) && heap[i/2] > heap[i]) {
				ex(i/2,i);
			}
		}
	}
	
	static int remove() {
		int del = heap[1];
		heap[1] = heap[node];
		heap[node--] = null;
		int now = 1;
		while(now * 2 <= node) {
			int l = now * 2;
			int r = now * 2 + 1;
			
			if(l == node) { // 마지막 노드 처리
				if(Math.abs(heap[l]) < Math.abs(heap[now])) {
					ex(l,now);
				}else if(Math.abs(heap[l]) == Math.abs(heap[now]) && heap[l] < heap[now]) {
					ex(l,now);
				}
				break;
			}
			
			if(Math.abs(heap[l]) < Math.abs(heap[now]) || Math.abs(heap[r]) < Math.abs(heap[now])) {
				if(Math.abs(heap[l]) < Math.abs(heap[r])) {
					ex(l,now);
					now = l;
				}else if(Math.abs(heap[l]) > Math.abs(heap[r])){
					ex(r,now);
					now = r;
				}else {
					if(heap[l] < heap[r]) {
						ex(l,now);
						now = l;
					}else {
						ex(r,now);
						now = r;
					}
				}
			}else {
				if(Math.abs(heap[l]) == Math.abs(heap[now]) && heap[l] < heap[now]) {
					ex(l,now);
					now = l;
					continue;
				}else if(Math.abs(heap[r]) == Math.abs(heap[now]) && heap[r] < heap[now]) {
					ex(r,now);
					now = r;
					continue;
				}
				break;
			}
		}
		return del;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String val;
		StringBuilder sb = new StringBuilder();
		while(n-- > 0) {
			val = in.readLine();
			if(val.equals("0")) {
				if(node == 0) {
					sb.append(0).append('\n');
				}else {
					// remove
					sb.append(remove()).append('\n');
				}
			}else {
				add(Integer.parseInt(val));
			}
		}
		in.close();
		
		System.out.print(sb);
	}
}