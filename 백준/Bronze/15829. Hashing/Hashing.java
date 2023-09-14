import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(in.readLine());
		char[] word = in.readLine().toCharArray();
		in.close();
		
		long sum = 0;
		final int mod = 1234567891;
		
		for(int i = 0; i < word.length; i++) {
			int now = word[i] - 'a' + 1;
			sum += (now * Math.pow(31, i))%mod;
			sum%=mod;
		}
		
		System.out.print(sum);
	}

}