import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Integer[] price = new Integer[n];
		for(int i = 0; i < n; i++) {
			price[i] = Integer.parseInt(in.readLine());
		}
		in.close();
		
		Arrays.sort(price, (i1,i2) -> i2 - i1);
		int sum = 0;
		for(int i = 0; i < n; i++) {
			if(i%3 != 2) {
				sum += price[i];
			}
		}	
		System.out.print(sum);
	}
}