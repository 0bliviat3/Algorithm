import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private int[] tree;
	
	Main(int n){
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		int size = 1 << h + 1;
		tree = new int[size];
	}
	// 트리 생성
	private void init(int node, int start, int end) {
		if(start == end) {
			tree[node] = 1;
		}else {
			int mid = (start + end)/2;
			init(node*2,start,mid);
			init(node*2+1,mid+1,end);
			tree[node] = tree[node*2] + tree[node*2+1];
		}
	}
	
	private int update(int node, int start, int end, int del) {
		tree[node]--;
		if(start == end) { // 지울수 찾으면 0으로 바꿈
			return 0;
		}else {
			int mid = (start + end)/2;
			if(del <= mid) {
				return update(node*2,start,mid,del);
			}else {
				return update(node*2+1,mid+1,end,del);
			}
		}
	}
	
	private int query(int node, int start, int end, int now) {
		if(start == end) {
			return start; // 순서에 해당하는 번호찾기
		}
		int mid = (start + end)/2;
		if(now <= tree[node*2]) {
			return query(node*2,start,mid,now);
		}else {
			return query(node*2+1,mid+1,end,now - tree[node*2]);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Main t = new Main(n);
		t.init(1, 1, n);
		int now = 1;
		sb.append("<");
		for(int i=0;i<n;i++) {
			int x = n - i;
			now += (k - 1);
			if(now%x == 0) { // 나머지가 0이면 남은 사람수로 찾아야 함
				now = x;
			}else if(now > x){
				now%=x;
			}
			
			int find = t.query(1, 1, n, now);
			t.update(1, 1, n, find);
			sb.append(find);
			if(i == n-1) {
				sb.append(">");
			}else {
				sb.append(", ");
			}
		}
		System.out.print(sb);
	}
	

}
