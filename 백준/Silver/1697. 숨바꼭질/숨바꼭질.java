import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * bfs 풀이
	 */
	
	static final int len = 100_001;
	static int n,k,front,rear;
	static int[] visit = new int[len];
	static int[] queue = new int[len];
	static int[] loc = new int[3];
	
	static int bfs() {
		queue[rear++] = n;
		visit[n] = 1;
		
		while(visit[k] == 0) {
			int node = queue[front];
			queue[front++] = 0;
			front%=len;
			
			loc[0] = node + 1;
			loc[1] = node - 1;
			loc[2] = node << 1;
			
			for(int i = 0; i < 3; i++) {
				if(loc[i] >= 0 && loc[i] < len && visit[loc[i]] == 0) {
					queue[rear++] = loc[i];
					rear%=len;
					visit[loc[i]] = visit[node] + 1;					
				}
			}
		}
		return visit[k] - 1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		in.close();
		
		System.out.print(bfs());
	}

}
