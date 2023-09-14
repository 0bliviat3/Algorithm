import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();
		int mod = 0;
		while(n != 0) {
			mod += n/5;
			n/=5;		
		}
		
		System.out.print(mod);
		
	}
	

}