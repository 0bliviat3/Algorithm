import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main m = new Main();
		StringBuilder sb = new StringBuilder();
		int[] fibo = m.fibo();
		int t = Integer.parseInt(in.readLine());
		while(t-- > 0) {
			int now = Integer.parseInt(in.readLine());
			sb.append(fibo[now + 1] - fibo[now] + " ");
			sb.append(fibo[now] + "\n");
		}
		in.close();
		
		System.out.print(sb);
		
	}
	
	private int[] num = new int[42];
	
	private int[] fibo() {
		num[0] = 0;
		num[1] = 1;
		for(int i = 2; i <= 41; i++) {
			num[i] = num[i - 1] + num[i - 2];
		}
		
		return num;
		
	}

}
