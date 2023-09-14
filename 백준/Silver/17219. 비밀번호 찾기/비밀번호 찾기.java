import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String,String> hmap = new HashMap<>();
		while(n-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			hmap.put(st.nextToken(), st.nextToken());
		}
		
		while(m-- > 0) {
			out.append(hmap.get(in.readLine()) + "\n");
		}
		
		in.close();
		out.flush();
		out.close();
	}

}