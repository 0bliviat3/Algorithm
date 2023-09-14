import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static void hanoi(int n, int start, int end, int mid) {
		if(n == 0) return;
		hanoi(n - 1,start,mid,end);
		sb.append(start + " " + end + "\n");					
		hanoi(n - 1,mid,end,start);
	}
	
	static BigInteger moveCnt(int n) {
		return new BigInteger("2").pow(n).subtract(BigInteger.ONE);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();
		
		sb.append(moveCnt(n) + "\n");
		
		if(n <= 20) hanoi(n,1,3,2);
		
		System.out.print(sb);
	}
	
}