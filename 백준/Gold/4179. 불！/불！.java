import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ4179Sol instance = new BOJ4179Sol();
		instance.run();
	}

}

class MazeNode {
	
	boolean isFire;
	int x;
	int y;
	
	MazeNode(int x, int y, boolean isFire) {
		this.x = x;
		this.y = y;
		this.isFire = isFire;
	}
	
}

class BOJ4179Sol {
	
	private int[][] metrix;
	private MazeNode[] queue;
	private int front, rear, row, col;
	private final int SIZE = 1_000_000;
	private int[][] move = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	private MazeNode jihoon;
	
	BOJ4179Sol() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void clear() {
		metrix = new int[row][col];
		queue = new MazeNode[SIZE];
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		clear();
		for(int i = 0; i < row; i++) { init(in.readLine(), i); }
		in.close();
	}
	
	private void init(String input, int row) {
		for(int i = 0; i < col; i++) {
			char val = input.charAt(i);
			init(val,row,i);
		}
	}
	
	private void init(char val, int row, int col) {
		switch (val) {
		case '#':
			metrix[row][col] = -1;
			break;
		case 'J':
			metrix[row][col] = 1;
			jihoon = new MazeNode(row,col,false);
			break;
		case 'F':
			metrix[row][col] = -2;
			queue[rear++] = new MazeNode(row,col,true);
			break;
		default:
			break;
		}
	}
	
	private int bfs() {
		queue[rear++] = jihoon;
		while(queue[front] != null) {
			MazeNode node = queue[front];
			queue[front++] = null;
			front %= SIZE;
			for(int i = 0; i < 4; i++) {
				int x = node.x + move[i][0];
				int y = node.y + move[i][1];
				if(x < 0 || y < 0 || x >= row || y >= col) {
					if(node.isFire) { continue; }
					return metrix[node.x][node.y];
				}
				if(metrix[x][y] == 0) {
					metrix[x][y] = metrix[node.x][node.y];
					if(!node.isFire) { metrix[x][y]++; }
					queue[rear++] = new MazeNode(x,y,node.isFire);
					rear %= SIZE;
				}
			}
		}
		return -1;
	}
	
	void run() {
		int time = bfs();
		if(time < 0) {
			System.out.print("IMPOSSIBLE");
		}else {
			System.out.print(time);
		}
	}
	
}
