import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[10001];
		
		while(n-- >0) {
			int idx = Integer.parseInt(in.readLine());
			arr[idx]++;
		}
		
		in.close();
		
		for(int i = 0; i < 10001; i++) {
			while(arr[i] > 0) {
				out.write(i+"\n");
				arr[i]--;
			}
		}
		
		out.flush();
		out.close();
	}

}