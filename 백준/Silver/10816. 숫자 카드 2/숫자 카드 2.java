import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		final int magicNumber = 10_000_000;
		
		int[] card = new int[magicNumber*2 + 1];
		
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		while(n-- > 0) {
			int idx = Integer.parseInt(st.nextToken());
			card[magicNumber + idx]++;
		}
		
		int m = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine()," ");
		in.close();
		while(m-- > 0) {
			int idx = Integer.parseInt(st.nextToken());
			out.write(card[magicNumber + idx] + " ");
		}
		
		out.flush();
		out.close();
	}

}
