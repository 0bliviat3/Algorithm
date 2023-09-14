import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] rope = new int[n];
		for(int i = 0; i < n; i++) { // n
			rope[i] = Integer.parseInt(in.readLine());
		}
		in.close();
		Arrays.sort(rope); // nlogn
		
		int max = 0;
		int now = 0;
		for(int i = 0; i < n; i++) { // n
			now = rope[n - 1 - i]*(i + 1);
			if(max < now) max = now;
		}
		
		System.out.print(max);
	}

}
