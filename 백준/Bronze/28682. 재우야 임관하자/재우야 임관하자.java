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
		
		for(int i = 0; i < n; i++) {
			out.append("swimming ");
		}
		out.flush();
		
		String[] F = in.readLine().split(" ");
		
		in.close();
		
		for(int i = 0; i < n; i++) {
			if(F[i].equals("bowling")) {
				out.append("soccer ");
			}else {
				out.append("bowling ");
			}
		}
		
		out.flush();
		out.close();
	}
}