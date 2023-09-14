import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int won = 0;
		if(f>t && f>s) {
			if(t == s) {
				won = 1000 + t*100;
			}else {
				won = f*100;
			}
		}else if(f>t && f<s) {
			won = s*100;
		}else if(f<t && f>s) {
			won = t*100;
		}else if(f == t && f != s) {
			won = 1000 + f*100;
		}else if(f == s && f != t) {
			won = 1000 + f*100;
		}else if(f == s && f == t) {
			won = 10000 + f*1000;
		}else if(f<s && f<t) {
			if(s == t) {
				won = 1000 + s*100;
			}else if(s<t) {
				won = t*100;
			}else {
				won = s*100;
			}
		}
		sb.append(won);
		System.out.println(sb);
	}

}