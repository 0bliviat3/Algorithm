import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ6593Sol instance = new BOJ6593Sol();
		instance.run();
	}

}

enum EscapeMessage {
	
	start("Escaped in "),
	end(" minute(s)."),
	trap("Trapped!");
	
	private String message;
	
	EscapeMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() { return message; }
	
}

class RoomInfo {
	int layer;
	int row;
	int col;
	
	RoomInfo(int layer, int row, int col) {
		this.layer = layer;
		this.row = row;
		this.col = col;
	}
}

class BOJ6593Sol {
	
	private final int[][][] metrix;
	private final BufferedReader in;
	private final StringBuilder sb;
	private final RoomInfo[] startEnd;
	private final int[][] move = { {0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0} };
	private int L,R,C;
	
	BOJ6593Sol() {
		metrix = new int[30][30][30];
		sb = new StringBuilder();
		in = new BufferedReader(new InputStreamReader(System.in));
		startEnd = new RoomInfo[2];
	}
	
	void run() {
		try {
			init();
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			System.out.print(sb);			
		}
	}
	
	private void init() throws IOException {
		while(initRun(in.readLine())) {
			for(int layer = 0; layer < L; layer++) {
				init(layer);
			}
			bfs(L*R*C,0,0);
			printProcess();
		}
	}
	
	private boolean initRun(String input) {
		StringTokenizer st = new StringTokenizer(input," ");
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		return L != 0;
	}
	
	private void init(int layer) throws IOException {
		for(int row = 0; row < R; row++) {
			init(in.readLine(), layer, row);
		}
		in.readLine();
	}
	
	private void init(String input, int layer, int row) {
		for(int col = 0; col < C; col++) {
			char key = input.charAt(col);
			init(key,layer,row,col);
		}
	}
	
	private void init(char key, int layer, int row, int col) {
		switch(key) {
		case 'S':
			init(0,layer,row,col);
			metrix[layer][row][col] = 0;
			break;
		case '.':
			metrix[layer][row][col] = 0;
			break;
		case '#':
			metrix[layer][row][col] = -1;
			break;
		case 'E':
			init(1,layer,row,col);
			metrix[layer][row][col] = 0;
			break;
		default:
			break;
		}
	}
	
	private void init(int idx, int layer, int row, int col) {
		startEnd[idx] = new RoomInfo(layer,row,col);
	}
	
	private void bfs(int size, int front, int rear) {
		RoomInfo[] queue = new RoomInfo[size];
		queue[rear++] = startEnd[0];
		while(queue[front] != null) {
			RoomInfo node = queue[front];
			queue[front++] = null;
			front %= size;
			for(int i = 0; i < 6; i++) {
				int dl = node.layer + move[i][0];
				int dr = node.row + move[i][1];
				int dc = node.col + move[i][2];
				if(dl < 0 || dl >= L || dr < 0 || dr >= R || dc < 0 || dc >= C) {
					continue;
				}
				if(metrix[dl][dr][dc] == 0) {
					metrix[dl][dr][dc] = metrix[node.layer][node.row][node.col] + 1;
					queue[rear++] = new RoomInfo(dl,dr,dc);
					rear %= size;
				}
			}
		}
	}
	
	private void printProcess() {
		int time = metrix[startEnd[1].layer][startEnd[1].row][startEnd[1].col];
		if(time > 0) {
			sb.append(String.join(time+"",
					EscapeMessage.start.getMessage(),EscapeMessage.end.getMessage()));
		}else {
			sb.append(EscapeMessage.trap.getMessage());
		}
		sb.append('\n');
	}
	
}
