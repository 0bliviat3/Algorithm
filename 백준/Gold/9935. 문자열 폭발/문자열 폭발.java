import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		BOJ9935Sol instance = new BOJ9935Sol();
		instance.run();
	}

}

class BOJ9935Sol {
	
	/*
	 * 스택에 문자를 저장하기보단
	 * 문자의 인덱스를 저장
	 * ex) 1 2 3 1 2 0 1 2 3
	 * top 과 다음 문자를 비교해서 
	 * 다음 문자인 경우 다음 인덱스로 저장
	 * 이때 문자열이 완성된다면 top -= 문자열 길이
	 */
	
	private final int[] stack;
	
	private char[] strArr;
	private String bomb;
	
	private int top = -1;
	private int bombSize;
	
	BOJ9935Sol() {
		stack = new int[1_000_001];
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		strArr = in.readLine().toCharArray();
		bomb = in.readLine();
		bombSize = bomb.length();
	}
	
	private void add(char val) {
		if(top != -1 && stack[top] < '0') {
			int idx = stack[top] + 1;
			if(bomb.charAt(idx) == val) { // 다음 문자인 경우
				stack[++top] = idx;
				return;
			}
		}
		if(bomb.charAt(0) == val) { // 첫 실행이거나, 첫번째 문자와 일치하는 경우
			stack[++top] = 0;
			return;
		}
		stack[++top] = val;
	}
	
	private void pop() {
		if(stack[top] + 1 == bombSize) { // 문자열이 완성된 경우
			top -= bombSize;
		}
	}
	
	private void chkStr() {
		for(char val : strArr) {
			add(val);
			pop();
		}
	}
	
	private void prtStr() {
		StringBuilder sb = new StringBuilder();
		if(top == -1) {
			sb.append("FRULA");
		}
		for(int i = 0; i <= top; i++) {
			if(stack[i] < '0') {
				sb.append(bomb.charAt(stack[i]));
			}else {
				sb.append((char) stack[i]);				
			}
		}
		System.out.print(sb);
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			chkStr();
			prtStr();
		}
	}
}
