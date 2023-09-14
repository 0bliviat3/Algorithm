import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private long[] arr = new long[100];
	
	public long fiboNum(int n) {
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 1;
		}else {
			if(this.arr[n] != 0) {
				return  this.arr[n];
			}else {
				arr[n] = fiboNum(n-1) + fiboNum(n-2);
				return arr[n];
			}
		}
	}
	
	public static void main(String[] arg0) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Main f = new Main();
		int n = Integer.parseInt(in.readLine());
		sb.append(f.fiboNum(n));
		System.out.print(sb);
	}
	
	
}