import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		Building instance = new Building();
		instance.run();
	}

}

class BuildArea {
	
	boolean isFire;
	int x;
	int y;
	
	BuildArea(int x, int y, boolean isFire) {
		this.x = x;
		this.y = y;
		this.isFire = isFire;
	}
}

class Building {
	
	private final int[][] metrix;
	private final BuildArea[] queue;
	private final StringBuilder sb;
	private final int SIZE = 1_000_000;
	private final int[][] move = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	private int front, rear, width, height;
	private BuildArea man;
	
	Building() {
		metrix = new int[1000][1000];
		queue = new BuildArea[SIZE];
		sb = new StringBuilder();
	}
	
	private void clear() { front = rear = 0; }
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		while(t-- > 0) {
			init(in.readLine());
			for(int i = 0; i < height; i++) { init(in.readLine(),i); }
			process();
		}
	}
	
	private void init(String input) {
		clear();
		StringTokenizer st = new StringTokenizer(input," ");
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
	}
	
	private void init(String input, int height) {
		for(int i = 0; i < width; i++) {
			char key = input.charAt(i);
			init(key, height, i);
		}
	}
	
	private void init(char key, int height, int width) {
		switch (key) {
		case '.':
			metrix[height][width] = 0;
			break;
		case '#':
			metrix[height][width] = -1;
			break;
		case '@':
			man = new BuildArea(height, width, false);
			metrix[height][width] = 1;
			break;
		case '*':
			queue[rear++] = new BuildArea(height, width, true);
			metrix[height][width] = -2;
			break;
		default:
			break;
		}
	}
	
	private int bfs() {
		queue[rear++] = man;
		while(queue[front] != null) {
			BuildArea node = queue[front];
			queue[front++] = null;
			front %= SIZE;
			for(int i = 0; i < 4; i++) {
				int x = node.x + move[i][0];
				int y = node.y + move[i][1];
				if(x < 0 || y < 0 || x >= height || y >= width) {
					if(!node.isFire) { return metrix[node.x][node.y]; }
					continue;
				}
				if(metrix[x][y] == 0) {
					metrix[x][y] = metrix[node.x][node.y];
					if(!node.isFire) { metrix[x][y]++; }
					queue[rear++] = new BuildArea(x, y, node.isFire);
					rear %= SIZE;
				}
			}
		}
		return -1;
	}
	
	private void process() {
		int bfs = bfs();
		if(bfs < 0) {
			sb.append("IMPOSSIBLE");
		}else {
			sb.append(bfs);
		}
		sb.append('\n');
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			System.out.print(sb);
		}
	}
	
}
