import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		while(n != -1) {
			int sum = 1;
			String result = n + " = 1";
			for(int i = 2; i < n; i++) {
				if(n % i == 0) {
					sum += i;
					result += " + " + i;
				}
			}
			if(n == sum) {
				System.out.println(result);
			}else {
				System.out.println(n + " is NOT perfect.");
			}
			n = Integer.parseInt(in.readLine());
		}
		
		in.close();

	}

}