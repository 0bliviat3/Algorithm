import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[] arr;
	static int[] stack;
	static StringBuilder sb = new StringBuilder();
	
	static void build() {
		for(int i = 1; i <= m; i++) {
			sb.append(stack[i]).append(' ');
		}
		sb.append('\n');
	}
	
	static void dfs(int cnt) {
		if(cnt == m + 1) {
			build();
			return;
		}
		for(int i = 0; i < n; i++) {
			if(stack[cnt - 1] <= arr[i]) {
				stack[cnt] = arr[i];
				dfs(cnt + 1);				
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		stack = new int[m + 1];
		
		st = new StringTokenizer(in.readLine()," ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(1);
		
		System.out.print(sb);
	}

}
