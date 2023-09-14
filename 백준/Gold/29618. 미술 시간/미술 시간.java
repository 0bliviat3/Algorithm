import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] picture;
	static int[] visit;
	
	static int find(int now) {
		if(visit[now] == 0) return now;
		return visit[now] = find(visit[now]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) visit[a] = b;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		picture = new int[n + 2];
		visit = new int[n + 2];
		
		int[] query = new int[3];
		
		while(q-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			for(int i = 0; i < 3; i++) {
				query[i] = Integer.parseInt(st.nextToken());
			}
			int start = query[0];
			while(find(start) <= query[1]) {
				picture[find(start)] = query[2];
				union(find(start), find(start) + 1);
				start = find(start);
			}
			
		}
		in.close();
		
		for(int i = 1; i <= n; i++) {
			sb.append(picture[i]).append(' ');
		}
		
		System.out.print(sb);
	}
	
}
