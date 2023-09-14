import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		int[] stack = new int[n+1];
		int top = 0; // top Idx
		int i = 1; // start number
		boolean flag = false;
		/* 수를 입력받고 > now
		 * top과 now 비교 작거나 같으면 pop
		 * 크다면 i와 비교 
		 * 작다면 NO
		 * 크거나 같다면 i++ push now가 i보다 작아질때까지
		 * 마지막에 pop
		 */
		while(n-- > 0) {
			int now = Integer.parseInt(in.readLine());
			
			if(stack[top] > now) {
				while(stack[top] != now) {
					stack[top--] = 0;
					sb.append("-\n");
				}
			}else if(stack[top] == now) {
				stack[top--] = 0;
				sb.append("-\n");
			}else if(stack[top] < now) {
				if(i > now) {
					// no
					flag = true;
				}else if(i <= now) {
					while(i<=now) {
						stack[++top] = i++;
						sb.append("+\n");
					}
					stack[top--] = 0;
					sb.append("-\n");
				}
			}
		}
		if(flag) {
			sb.setLength(0);
			sb.append("NO");
		}
		System.out.print(sb);

	}

}