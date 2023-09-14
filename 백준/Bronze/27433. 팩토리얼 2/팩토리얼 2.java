import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());
		in.close();
		System.out.print(fac(n));
	}
	
	static long fac(long n) {
		if(n == 1 || n == 0) {
			return 1;
		}
		return n*fac(n - 1);
	}

}