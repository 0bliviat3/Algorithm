import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] tree;
	static int n,m;
	
	// 조건 분기 method
	static boolean isPossible(long height) {
		long gap = 0;
		for(int i = 0; i < n; i++) {
			if(tree[i] > height) {
				gap += (tree[i] - height);
			}
		}
		return m <= gap; //같거나 차가 더 큰 경우 true 
	}
	// 이분탐색 method
	static long getHeight(long max) { // tree 배열의 값중 최대값을 인자로 받는다
		long mid = 0;
		long start = 1;
		while(start <= max) {
			mid = (start + max)/2;
			if(isPossible(mid)) { // 같거나 차가 더 큼
				start = mid + 1;
			}else {
				max = mid - 1;
			}
		}
		return max;	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine()," ");
		tree = new int[n];
		long max = 0;
		for(int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = (max < tree[i]) ? tree[i] : max;
		}		
		in.close();
		System.out.print(getHeight(max));
	}

}
