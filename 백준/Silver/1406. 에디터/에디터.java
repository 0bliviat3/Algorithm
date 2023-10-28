import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		Boj1406Sol instance = new Boj1406Sol();
		instance.run();
	}

}

class Boj1406Sol {
	
	private final char[][] stack;
	private int top1, top2;
	
	Boj1406Sol() {
		stack = new char[2][600_000];
		top1 = top2 = -1;
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		init(in.readLine());
		int m = Integer.parseInt(in.readLine());
		while(m-- > 0) {
			order(in.readLine());
		}
	}
	
	private void init(String str) {
		for(int i = 0; i < str.length(); i++) {
			stack[0][++top1] = str.charAt(i);
		}
	}
	
	private void order(String order) {
		StringTokenizer st = new StringTokenizer(order," ");
		switch (st.nextToken()) {
		case "L":
			if(top1 >= 0) {
				stack[1][++top2] = stack[0][top1--];
			}
			break;
		case "D":
			if(top2 >= 0) {
				stack[0][++top1] = stack[1][top2--];
			}
			break;
		case "B":
			if(top1 >= 0) {
				top1--;
			}
			break;
		case "P":
			stack[0][++top1] = st.nextToken().charAt(0);
			break;
		default:
			break;
		}
	}
	
	private String build() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= top1; i++) {
			sb.append(stack[0][i]);
		}
		for(int i = top2; i >= 0; i--) {
			sb.append(stack[1][i]);
		}
		return sb.toString();
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			System.out.print(build());
		}
	}
	
}
