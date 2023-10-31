import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		BOJ1935Sol instance = new BOJ1935Sol();
		instance.run();
	}

}

class BOJ1935Sol {
	
	private final double[] numbers;
	
	private final Stack<Double> stack;
	
	BOJ1935Sol() {
		numbers = new double[26];
		stack = new Stack<>();
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String postFix = in.readLine();
		for(int i = 0; i < n; i++) {
			numbers[i] = Double.parseDouble(in.readLine());
		}
		cal(postFix);
	}
	
	private void cal(String postFix) {
		for(char val : postFix.toCharArray()) {
			cal(val);
		}
		System.out.printf("%.2f",stack.pop());
	}
	
	private void cal(char key) {
		switch (key) {
		case '*':
			double b = stack.pop();
			double a = stack.pop();
			stack.push(a * b);
			break;
		case '-':
			b = stack.pop();
			a = stack.pop();
			stack.push(a - b);
			break;
		case '+':
			b = stack.pop();
			a = stack.pop();
			stack.push(a + b);
			break;
		case '/':
			b = stack.pop();
			a = stack.pop();
			stack.push(a / b);
			break;
		default:
			stack.push(numbers[key - 'A']);
			break;
		}
	}
}
