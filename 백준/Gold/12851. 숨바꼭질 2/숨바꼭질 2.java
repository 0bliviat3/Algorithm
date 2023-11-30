import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ12851Sol instance = new BOJ12851Sol();
		instance.run();
	}

}

class BOJ12851Sol {
	
	private int n, k;
	private int[][] visit;
	
	private void clear() {
		visit = new int[100_001][2];
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	}
	
	private void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visit[n][0] = 1;
		visit[n][1]++;
		
		while(!queue.isEmpty()) {
			
			int now = queue.remove();
			
			int[] move = {now * 2, now + 1, now - 1};
			for(int i : move) {
				
				if(i < 0 || i > 100_000) {
					continue;
				}
				
				if(visit[i][0] > 0) {
					// 방문한 경우
					if(visit[i][0] == visit[now][0] + 1) {
						visit[i][1]++;
						queue.add(i);
					}
					continue;
				}
				
				visit[i][0] = visit[now][0] + 1;
				visit[i][1]++;
				queue.add(i);
			}
		}
	}
	
	private void printAns() {
		System.out.print(visit[k][0] - 1 + "\n" + visit[k][1]);
	}
	
	void run() {
		try {
			init();
			clear();
			bfs();
			printAns();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
