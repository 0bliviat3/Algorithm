import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private int[] arr;
	private long[] tree;
	
	Main(int n){
		arr = new int[n];
		tree = new long[treeSize(n)];
	}
	
	private int treeSize(int n) {
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		return 1 << (h+1);
	}
	
	private void init(int node, int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
		}else {
			int mid = (start + end)/2;
			init(node*2,start,mid);
			init(node*2+1,mid+1,end);
			tree[node] = tree[node*2] + tree[node*2+1];
		}
	}
	
	private long query(int node,int start, int end,int left, int right) {
		if(left > end || right < start) {
			return 0;
		}
		if(left <= start && right >= end) {
			return tree[node];
		}
		int mid = (start + end)/2;
		long m1 = query(node*2,start,mid,left,right);
		long m2 = query(node*2+1,mid+1,end,left,right);
		return m1 + m2; // **
	}
	
	private void update(int end, int idx, int value) {
		long diff = (long)value - (long)arr[idx];
		arr[idx] = value;
		updateTree(1,idx,0,end-1,diff);
	}
	
	private void updateTree(int node, int idx, int start, int end, long diff) {
		if(idx > end || idx < start) {
			return;
		}
		tree[node] += diff;
		if(start != end) {
			int mid = (start + end)/2;
			updateTree(node*2,idx,start,mid,diff);
			updateTree(node*2+1,idx,mid+1,end,diff);		
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		Main t = new Main(n);
		st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<n;i++) {
			t.arr[i] = Integer.parseInt(st.nextToken());
		}
		t.init(1, 0, n-1);
		while(q-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());			
			sb.append(t.query(1, 0, n-1, Math.min(x, y)-1, Math.max(x, y)-1) + "\n");
			t.update(n, a-1, b);
		}
		
		System.out.print(sb);
	}

}
