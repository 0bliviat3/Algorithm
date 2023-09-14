import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * BFS
	 */
	
	static int[] board = new int[101];
	
	static int[] snake = new int[101];
	
	static int[] queue = new int[100];
	
	static int front,rear;
	
	static int bfs() {
		queue[rear++] = 1;
		while(queue[front] != 0) {
			int node = queue[front];
			queue[front++] = 0;
			front%=100;
			for(int i = 1; i < 7; i++) {
				int next = node + i;
				if(next <= 100) {
					if(snake[next] != 0) {
						next = snake[next];
					}
					
					if(board[next] == 0) {
						board[next] = board[node] + 1;
						queue[rear++] = next;
						rear%=100;
					}					
				}
				
			}
		}
		return board[100];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		n += Integer.parseInt(st.nextToken());
		
		while(n-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			int idx = Integer.parseInt(st.nextToken());
			snake[idx] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(bfs());
	}

}
