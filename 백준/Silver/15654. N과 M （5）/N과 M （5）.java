import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[] arr;
	static int[] stack;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	static void build() {
		for(int i = 0; i < m; i++) {
			sb.append(stack[i]).append(' ');
		}
		sb.append('\n');
	}
	
	static void dfs(int cnt) {
		if(cnt == m) {
			build();
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				stack[cnt] = arr[i];
				visit[i] = true;
				dfs(cnt + 1);
				visit[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		stack = new int[m];
		visit = new boolean[n];
		
		st = new StringTokenizer(in.readLine()," ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
		System.out.print(sb);
	}

}
