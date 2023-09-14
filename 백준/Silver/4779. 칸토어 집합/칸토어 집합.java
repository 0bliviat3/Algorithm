import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static boolean[] arr = new boolean[1];
	
	static void cantor(int x, int n, boolean flag) {
		if(flag) {
			for(int i = x; i < x + n; i++) {
				arr[i] = true;
			}
			return;
		}
		
		if(n == 1) return;
		
		int now = n/3;
		int cnt = 0;
		
		for(int i = x; i < x + n; i += now) {
			cnt++;
			if(cnt == 2) {
				cantor(i,now,true);
			}else {
				cantor(i,now,false);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp = in.readLine();
		
		while(temp != null && !temp.isEmpty()) {
			int n = (int) Math.pow(3,Integer.parseInt(temp));
			
			if(n > arr.length) {
				arr = new boolean[n];				
				cantor(0,n,false);
			}
			
			for(int i = 0; i < n; i++) {
				if(!arr[i]) {
					out.append('-');
				}else {
					out.append(' ');
				}
			}
			out.append('\n');
			temp = in.readLine();
		}
		
		in.close();
		out.flush();
		out.close();
	}

}
