import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 받은 전깃줄 왼쪽기준 정렬
	 * 전기줄 차례로 순회
	 * left(n) < left(n + 1) && right(n) < right(n + 1)일때만 구조가 성립
	 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st;
		ElecLine[] el = new ElecLine[n];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			el[i] = new ElecLine(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(el);
		
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j <= i; j++) {
				if(el[i].left > el[j].left && el[i].right > el[j].right) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.print(n - max);
		
	}

}

class ElecLine implements Comparable<ElecLine>{
	int left = 0;
	int right = 0;
	
	ElecLine(int left, int right){
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(ElecLine o) {
		return this.left - o.left;
	}
}
