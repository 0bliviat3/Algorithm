import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ2493SOl instance = new BOJ2493SOl();
		instance.run();
	}

}


class BOJ2493SOl {
	
	private final Point[] stack;
	private final StringBuilder sb;
	private int top;
	
	BOJ2493SOl() {
		stack = new Point[500_001];
		sb = new StringBuilder();
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		add(in.readLine(),n);
	}
	
	private void add(String input, int n) {
		StringTokenizer st = new StringTokenizer(input," ");
		for(int i = 1; i <= n; i++) {
			int val = Integer.parseInt(st.nextToken());
			add(val,i);
		}
	}
	
	private void add(int val, int idx) {
		
		while(top > 0 && stack[top].x < val) { top--; }
		if(top <= 0) {
			sb.append(0).append(' ');
		}else {
			sb.append(stack[top].y).append(' ');
		}
		stack[++top] = new Point(val,idx);
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