import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ14582Sol instance = new BOJ14582Sol();
		instance.run();
	}
	
}

class BOJ14582Sol {
	
	private StringTokenizer[] st = new StringTokenizer[2];
	private int[] sum = new int[2];
	private boolean flag;
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st[0] = new StringTokenizer(in.readLine()," ");
		st[1] = new StringTokenizer(in.readLine()," ");
	}
	
	private void countScore(int idx) {
		sum[idx] += Integer.parseInt(st[idx].nextToken());
	}
	
	private void setFlag() {
		for(int i = 0; i < 9; i++) {
			countScore(0);
			if(sum[0] > sum[1]) { flag = true; }
			countScore(1);
		}
	}
	
	private void printResult() {
		if(flag) {
			System.out.print("Yes");
		}else {
			System.out.print("No");
		}
	}
	
	void run() {
		try {
			init();
			setFlag();
			printResult();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
