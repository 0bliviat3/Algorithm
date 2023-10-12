import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	/*
	 * 2개의 스택사용
	 * < : stack1 pop & stack2 push
	 * > : stack2 pop & stack1 push
	 * - : stack1 !is empty stack1 pop
	 */
	
	public static void main(String[] args) {
		BOJ5397Sol instance = new BOJ5397Sol();
		System.out.print(instance.getPass());
	}
}

class BOJ5397Sol {
	
	private char[][] stack;
	private int[] top;
	private StringBuilder sb;
	
	BOJ5397Sol() {
		sb = new StringBuilder();
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void clear() { top[0] = top[1] = 0; }
	
	private void init() throws IOException {
		stack = new char[1_000_000][2];
		top = new int[2];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		while(n-- > 0) {
			clear();
			setPass(in.readLine());
		}
		in.close();
	}
	
	private boolean isEmpty(int stackIdx) {
		return top[stackIdx] == 0;
	}
	
	private void push(char val, int stackIdx) {
		stack[top[stackIdx]++][stackIdx] = val;
	}
	
	private char pop(int stackIdx) {
		return stack[--top[stackIdx]][stackIdx];
	}
	
	private void arrowProcess(int start, int end) {
		if(isEmpty(start)) return;
		push(pop(start),end);
	}
	
	private void order(char val) {
		switch (val) {
		case '<':
			arrowProcess(0,1);
			break;
		case '>':
			arrowProcess(1,0);
			break;
		case '-':
			if(!isEmpty(0)) { pop(0); }
			break;
		default:
			push(val,0);
			break;
		}
	}
	
	private void setPass(String input) {
		for(char val : input.toCharArray()) { order(val); }
		for(int i = 0; i < top[0]; i++) { sb.append(stack[i][0]); }
		while(!isEmpty(1)) { sb.append(pop(1)); }
		sb.append('\n');
	}
	
	String getPass() { return sb.toString(); }
}
