import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ5014Sol instance = new BOJ5014Sol();
		instance.run();
		instance.close();
	}

}

class BOJ5014Sol {
	
	private int[] visit;
	private int[] data;
	
	BOJ5014Sol() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void clear(int n) { 
		visit = new int[n + 1];
		data[4] *= -1;
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		this.data = new int[5];
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		for(int i = 0; i < 5; i++) { data[i] = Integer.parseInt(st.nextToken()); }
		clear(data[0]);
		in.close();
	}
	
	private int bfs() {
		Integer[] queue = new Integer[data[0]];
		int front = 0;
		int rear = 0;
		
		queue[rear++] = data[1];
		visit[data[1]] = 1;
		while(queue[front] != null) {
			int stair = queue[front];
			queue[front++] = null;
			front %= data[0];
			for(int i = 3; i < 5; i++) {
				int next = stair + data[i];
				if(next > 0 && next <= data[0] && visit[next] == 0) {
					visit[next] = visit[stair] + 1;
					queue[rear++] = next;
					rear %= data[0];
				}
			}
		}
		return visit[data[2]] - 1;
	}
	
	void run() {
        if(data[1] == data[2]) {
			System.out.print(0);
			return;
		}
		int min = bfs();
		if(min > 0) {
			System.out.print(min);
			return;
		}
		System.out.print("use the stairs");
	}
	
	
	void close() {
		visit = null;
		data = null;
	}
	
}
