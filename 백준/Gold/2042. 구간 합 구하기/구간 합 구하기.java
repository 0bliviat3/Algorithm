import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		m += Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		int i = 0;
		int n2 = n;
		while(n2-- >0) {
			arr[i++] = Long.parseLong(in.readLine());
		}
		long[] tree = new long[n*4];
		Main t = new Main();
		i = 0;
		t.init(arr, tree, 1, 0, n-1); // 세그먼트 트리 생성
		
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			if(a == 1) { // arr 숫자가 바뀌는 경우
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				t.update(arr, tree, n-1, b-1, c);
			}else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long sum = t.query(tree, 1, 0, n-1, b-1, c-1); // a가 2일때 구간의 합을 구함
				sb.append(sum);
				sb.append("\n");
			}
		}
        in.close();
		
		System.out.print(sb);
		
		
	}
	
	private void init(long[] arr, long[] tree, int node, int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
		}else {
			init(arr, tree, node*2,start,(start+end)/2);
			init(arr, tree, node*2+1, (start+end)/2 + 1, end);
			tree[node] = tree[node*2] + tree[node*2 + 1];
		}
	}
	
	private long query(long[] tree, int node, int start, int end, int left, int right) {
		if(left > end || right < start) {
			return 0;
		}
		if(left <= start && right >= end) {
			return tree[node];
		}
		long leftSum = query(tree,node*2,start,(start+end)/2,left,right);
		long rightSum = query(tree,node*2+1,(start+end)/2+1,end,left,right);
		return leftSum + rightSum;
	}
	
	private void updateTree(long[] tree,int node, int start, int end, int index, long gap) {
		if(index < start || index > end) {
			return;
		}
		tree[node] += gap; // 구간에 해당하는 모든 node의 값을 바꿔주어야 한다.
		if(start != end) { // 최하위 노드 즉 리프노드까지 재귀시작
			updateTree(tree,node*2,start,(start+end)/2,index,gap);
			updateTree(tree,node*2+1,(start+end)/2+1,end,index,gap);
		}
	}
	
	// 선택한 index번째의 노드를 value로 변경하는 method
	private void update(long[] arr, long[] tree, int n, int index, long value) {
		long gap = value - arr[index];
		arr[index] = value;
		updateTree(tree,1,0,n,index,gap);
	}

}
