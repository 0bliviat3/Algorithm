import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ17298Sol instance = new BOJ17298Sol();
		instance.run();
	}

}

class BOJ17298Sol {
	
	private final Stack<Integer> stack;
	
	BOJ17298Sol() {
		stack = new Stack<>();
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(in.readLine());
		init(size,in.readLine());
	}
	
	private void init(int size, String input) {
		int[] arr = new int[size];
		StringTokenizer st = new StringTokenizer(input," ");
		for(int i = 0; i < size; i++) { 
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		process(arr,size);
	}
	
	private void process(int[] arr, int size) {
		Stack<Integer> ans = new Stack<>();
		while(size-- > 0) {
			ans.push(process(arr[size]));
			stack.add(arr[size]);
		}
		prtAns(ans);
	}
	
	private Integer process(int val) {
		while(!stack.isEmpty()) {
			int top = stack.peek();
			if(val < top) {
				return top;
			}
			stack.pop();
		}
		return -1;
	}
	
	private void prtAns(Stack<Integer> ans) {
		StringBuilder sb = new StringBuilder();
		while(!ans.isEmpty()) {
			sb.append(ans.pop()).append(' ');
		}
		System.out.print(sb);
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
