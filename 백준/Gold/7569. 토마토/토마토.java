import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	int x,y,z;
	
	Main(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int size = n*m*h;
		int front = 0;
		int rear = 0;
		int cnt = 0;
		int max = 0;
		boolean flag = false;
		
		int[][][] metrix = new int[h][m][n];
		Main[] queue = new Main[size];
		Main[] start = new Main[size];
		
		int[] dx = { 0 , 1 , 0 , -1 , 0 , 0 };
		int[] dy = { 1 , 0 , -1 , 0 , 0 , 0 };
		int[] dz = { 0 , 0 , 0 , 0 , 1 , -1 };
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < m; j++) {
				st = new StringTokenizer(in.readLine()," ");
				for(int k = 0; k < n; k++) {
					metrix[i][j][k] = Integer.parseInt(st.nextToken());
					if(metrix[i][j][k] == 1) {
						start[cnt++] = new Main(i,j,k);
					}else if(metrix[i][j][k] == 0) {
						flag = true;
					}
				}
			}
		}
		
		in.close();
		
		for(int i = 0; i < cnt; i++) {
			queue[rear++] = start[i];
		}
		
		while(queue[front] != null) {
			Main node = queue[front];
			queue[front++] = null;
			front%=size;
			for(int i = 0; i < 6; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];
				int z = node.z + dz[i];
				
				if(x >= 0 && y >= 0 && z >= 0 &&
						x < h && y < m && z < n &&
						metrix[x][y][z] == 0) {
					queue[rear++] = new Main(x,y,z);
					rear%=size;
					metrix[x][y][z] = metrix[node.x][node.y][node.z] + 1;
				}
			}
		}
		
		if(flag) {
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < m; j++) {
					for(int k = 0; k < n; k++) {
						if(metrix[i][j][k] == 0) {
							flag = false;
						}
						max = Math.max(max, metrix[i][j][k]);
					}
				}
			}
			
			max = (flag) ? max : 0;
			
			System.out.print(--max);
		}else {
			System.out.print(0);
		}
		
	}

}
