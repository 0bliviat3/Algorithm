import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static void hanoi(int n, int start, int end, int mid) {
		if(n == 0) return;
		hanoi(n - 1,start,mid,end);
		sb.append(start + " " + end + "\n");					
		hanoi(n - 1,mid,end,start);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();
		
		int k = (1 << n) - 1;
		
		sb.append(k + "\n");
		
		hanoi(n,1,3,2);
		
		System.out.print(sb);
	}
	
}
