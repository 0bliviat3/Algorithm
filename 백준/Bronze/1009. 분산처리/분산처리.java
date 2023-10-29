import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ1009Sol instance = new BOJ1009Sol();
		instance.run();
	}

}


class BOJ1009Sol {
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		while(t-- > 0) {
			sb.append(cal(in.readLine())).append('\n');
		}
		System.out.print(sb);
	}
	
	private int cal(String testCase) {
		StringTokenizer st = new StringTokenizer(testCase," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		a %= 10;
		b %= 4;
		return cal(a, b);
	}
	
	private int cal(int a, int b) {
		if(a == 0) { return 10; }
		b += 3;
		b %= 4;
		int mod = a;
		while(b-- > 0) {
			a *= mod;
			a %= 10;
		}
		return a;
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}