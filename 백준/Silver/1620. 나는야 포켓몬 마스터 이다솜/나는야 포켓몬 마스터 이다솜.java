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
		
		HashMap<String,String> fuckingMon = new HashMap<>();
		
		for(int i = 1; i <= n; i++) { // insert
			String now = in.readLine();
			String idx = String.valueOf(i);
			fuckingMon.put(now,idx);
			fuckingMon.put(idx, now);
		}
		
		while(m-- > 0) {
			out.write(fuckingMon.get(in.readLine()) + "\n");
		}
		in.close();
        
		out.flush();
		out.close();
	}

}
