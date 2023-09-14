import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int per = (int) Math.round(n * 0.15);
		
		double mod = n - per*2;
		
		int[] rank = new int[n];
		int idx = 0;
		while(n-- >0) {
			rank[idx++] = Integer.parseInt(in.readLine());
		}
		
		in.close();
		
		Arrays.sort(rank);
		
		int sum = 0;
		for(int i = per; i < rank.length - per; i++) {
			sum+=rank[i];
		}
		
		int avg = (int) Math.round(sum/mod);
		
		System.out.print(avg);
		
	}

}