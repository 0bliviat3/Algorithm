import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static boolean[] visit;
	static int[] arr,nums;
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	
	static void build() {
		for(int i = 0; i < m; i++) {
			sb.append(arr[i]).append(' ');
		}
		set.add(sb.toString());
		sb.setLength(0);
	}
	
	static void dfs(int cnt) {
		if(cnt == m) {
			build();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[cnt] = nums[i];
				dfs(cnt + 1);
				visit[i] = false;
			}
		}
	}
	
	static String getPrt() {
		set.forEach(key -> {
			sb.append(key).append('\n');
		});
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n];
		arr = new int[m];
		nums = new int[n];
		
		st = new StringTokenizer(in.readLine()," ");
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		in.close();
		
		Arrays.sort(nums);
		
		dfs(0);
		
		System.out.print(getPrt());
		
		
	}
}
