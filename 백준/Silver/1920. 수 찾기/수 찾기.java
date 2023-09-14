import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int[] number = new int[n];
		for(int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(number);
		
		int m = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine()," ");
		in.close();
        
		while(m-- > 0) {
			int chk = Arrays.binarySearch(number, Integer.parseInt(st.nextToken()));
			int flag = (chk < 0) ? 0 : 1;
			out.write(flag + "\n");
		}
		
		out.flush();
		out.close();
	}

}
