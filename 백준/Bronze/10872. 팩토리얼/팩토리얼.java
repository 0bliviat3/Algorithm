import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		System.out.print(fac(n));
	}
	
	static int fac(int num) {
		if(num == 1 || num == 0) {
			return 1;
		}
		return num*fac(num - 1);
	}

}