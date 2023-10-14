import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ14503Sol instance = new BOJ14503Sol();
		instance.run();
	}
	
}

class BOJ14503Sol {
	
	private Boolean[][] metrix;
	private int cleanRoom,x,y;
	
	private int[] dx = { -1 , 0 , 1 , 0 };
	private int[] dy = { 0 , 1 , 0 , -1 };
	
	private int[] robot = new int[3];
	
	private StringTokenizer st;
	
	BOJ14503Sol() {
		try {
			init();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void clear(String input)  {
		st = new StringTokenizer(input," ");
		this.x = Integer.parseInt(st.nextToken());
		this.y = Integer.parseInt(st.nextToken());
		metrix = new Boolean[x][y];
	}
	
	private void setStart(String input) {
		st = new StringTokenizer(input," ");
		for(int i = 0; i < 3; i++) { robot[i] = Integer.parseInt(st.nextToken()); }
	}
	
	private void setMetrix(String input, int row) {
		st = new StringTokenizer(input," ");
		for(int j = 0; j < y; j++) {
			if(st.nextToken().equals("1")) { metrix[row][j] = true; }
		}
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		clear(in.readLine());
		setStart(in.readLine());
		for(int i = 0; i < x; i++) { setMetrix(in.readLine(),i); }
		in.close();
	}
	
	private void back() {
		int way = (robot[2] + 2)%4;
		robot[0] += dx[way];
		robot[1] += dy[way];
	}
	
	private void forward(int way) {
		robot[0] += dx[way];
		robot[1] += dy[way];
	}
	
	private int lotaion() {
		int way = robot[2] = (robot[2] + 3) % 4;
		return way;
	}
	
	private boolean isEmpty() {
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			int x = robot[0] + dx[i];
			int y = robot[1] + dy[i];
			if(x >= 0 && x < this.x && y >= 0 && y < this.y) {
				if(metrix[x][y] != null) { cnt++; }
			}else { cnt++; }
		}
		return cnt == 4;
	}
	
	private void cleanProcess() {
		
		while(true) {			
			// 현재칸이 청소되지 않은 경우
			if(metrix[robot[0]][robot[1]] == null) {
				metrix[robot[0]][robot[1]] = false;
				cleanRoom++;
			}
			// 4칸중 청소되지 않은 빈칸이 없는 경우
			if(isEmpty()) { 
				// 뒤로 후진 불가능한 경우
				int x = robot[0] + dx[(robot[2] + 2)%4];
				int y = robot[1] + dy[(robot[2] + 2)%4];
				if(x < 0 || y < 0 || x >= this.x || y >= this.y || (metrix[x][y] != null && metrix[x][y])) {
					return;
				}
				// 뒤로 후진 가능한 경우
				back();
			}else {
				int way = lotaion();
				int x = robot[0] + dx[way];
				int y = robot[1] + dy[way];
				// 청소되지 않은 빈칸인 경우
				if(x >= 0 && x < this.x && y >= 0 && y < this.y && metrix[x][y] == null) {
					forward(way);
				}
			}
		}
	}
	
	void run() {
		cleanProcess();
		System.out.print(cleanRoom);
	}

	
}
