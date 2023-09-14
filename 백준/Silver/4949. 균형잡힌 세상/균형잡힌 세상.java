import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Main m = new Main();
		String input = in.readLine();
		while(!input.equals(".")) {
			sb.append(m.judge(input));
			sb.append("\n");
			input = in.readLine();
		}
		in.close();
		System.out.print(sb);

	}
	
	
	private String judge(String input) {
		char[] stack = new char[input.length()];
		int top = 0;
		int i = 0;
		while(i<input.length()) {
			char temp = input.charAt(i++);
			if(temp == '[' || temp == '(') {
				stack[top++] = temp;
			}else if(temp == ']') {
                if(top == 0) {
					return "no";
				}
				if(stack[--top] == '[') {
					stack[top] = 0;
				}else {
					return "no";
				}
			}else if(temp == ')') {
                if(top == 0) {
					return "no";
				}
				if(stack[--top] == '(') {
					stack[top] = 0;
				}else {
					return "no";
				}
			}
		}
		if(stack[0] != 0) {
			return "no";
		}
		return "yes";
	}

}