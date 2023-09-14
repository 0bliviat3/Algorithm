import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();
		int value = 2;
		for(int i = 0; i < n; i++) {
			value += 1 << i;
		}
		
		System.out.print(value*value);
		

	}

}