import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		BOJ2448Sol instance = new BOJ2448Sol();
		instance.run();
	}

}

class BOJ2448Sol {
	
	private char[][] picture;
	private int n;
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(
				new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
	}
	
	private void clear() {
		picture = new char[n][n << 1];
	}
	
	private void draw(int x, int y) {
		picture[x][y] = '*';
		picture[x + 1][y - 1] = '*';
		picture[x + 1][y + 1] = '*';
		for(int i = y - 2; i <= y + 2; i++) {
			picture[x + 2][i] = '*';
		}
	}
	
	private void cut(int x, int y, int n) {
		if(n == 3) {
			draw(x, y);
			return;
		}
		n >>= 1;
		cut(x, y, n);
		cut(x + n, y - n, n);
		cut(x + n, y + n, n);
	}
	
	private void printPicture() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n * 2 - 1; j++) {
				if(picture[i][j] == 0) {
					sb.append(' ');
					continue;
				}
				sb.append(picture[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	void run() {
		try {
			init();
			clear();
			cut(0, n - 1, n);
			printPicture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}