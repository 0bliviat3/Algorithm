import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Main t = new Main();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		long[] tree = new long[t.treeSize(n)];
		long[] tree2 = new long[t.treeSize(n)];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		t.init(arr, tree, tree2, 1, 0, n-1);
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());		
			long max = t.query(tree, 1, 0, n-1, a-1, b-1);
			long min = t.query2(tree2, 1, 0, n-1, a-1, b-1);
			sb.append(min+" "+max+"\n");
		}
		in.close();
		System.out.print(sb);
	}
	
	private int treeSize(int n) {
		int h = (int)Math.ceil(Math.log(n) / Math.log(2));
		int size = 1 << (h+1);
		return size;
	}
	// 트리생성
	private void init(long[] arr, long[] tree, long[]tree2 ,int node, int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
			tree2[node] = arr[end];
		}else {
			int mid = (start + end)/2;
			init(arr,tree,tree2,node*2,start,mid);
			init(arr,tree,tree2,node*2 + 1 ,mid + 1,end);
			tree[node] = Math.max(tree[node*2], tree[node*2+1]);
			tree2[node] = Math.min(tree2[node*2], tree2[node*2+1]);
		}
	}
	// 구간에서 제일 큰수 찾기
	private long query(long[]tree, int node, int start, int end, int left, int right) {
		if(left > end || right < start) {
			return 0;
		}
		if(left <= start && right >= end) {
			return tree[node];
		}
		int mid = (start + end)/2;
		long leftMax = query(tree,node*2,start,mid,left,right);
		long rightMax = query(tree,node*2+1,mid+1,end,left,right);
		if(leftMax<=rightMax) {
			return rightMax;
		}else {
			return leftMax;
		}
	}
	
	// 구간에서 제일 작은수 찾기
	private long query2(long[]tree, int node, int start, int end, int left, int right) {
		if(left > end || right < start) {
			return 1000000001;
		}
		if(left <= start && right >= end) {
			return tree[node];
		}
		int mid = (start + end)/2;
		long leftMin = query2(tree,node*2,start,mid,left,right);
		long rightMin = query2(tree,node*2+1,mid+1,end,left,right);
		if(leftMin<=rightMin) {
			return leftMin;
		}else {
			return rightMin;
		}
	}
	

}
