import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static void build(StringBuilder sb, int m, int[] memo) {
		for(int i = 0; i < m; i++) {
			sb.append(memo[i]).append(' ');
		}
		sb.append('\n');
	}
	
	static void dfs(int start, int depth, int n, int m, StringBuilder sb, int[] arr, int[] memo) {
		if(depth == m) {
			build(sb,m,memo);
			return;
		}
		int before = 0;
		for(int i = start; i < n; i++) {
			if(before != arr[i]) {
				before = memo[depth] = arr[i];
				dfs(i,depth + 1,n,m,sb,arr,memo);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int[] memo = new int[m];
		
		st = new StringTokenizer(in.readLine()," ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		in.close();
		
		Arrays.sort(arr);
		
		dfs(0,0,n,m,sb,arr,memo);
		
		System.out.print(sb);
	}

}
