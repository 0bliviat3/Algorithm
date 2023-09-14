import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		Main m = new Main();
		while(t-- > 0) {
			String ps = in.readLine();
			sb.append(m.chkVPS(ps));
			sb.append("\n");
		}
		in.close();
		System.out.print(sb);
	}
	
	private String chkVPS(String ps) {
		int n = ps.length();
		char[] stack = new char[n];
		int top = 0;
		int i = 0;
		while(n-- > 0) {
			char now = ps.charAt(i++);
			if(now == '(') {
				stack[top++] = now; // push
			}else {
				if(top == 0) {
					return "NO";
				}else {
					stack[--top] = 0; // pop	
				}
			}
		}
		if(stack[0] != 0) {
			return "NO";
		}
		return "YES";
	}

}