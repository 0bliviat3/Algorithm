import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String text;
	static int n,mod,count;
	
	static void getCnt(boolean flag, int i, int cnt) {
		if(i == n) return;
		if(cnt == mod && text.charAt(i) == 'I') {
			count++;
			return;
		}
		if(text.charAt(i) == 'I') {
			if(flag) return;
			getCnt(true,i + 1,cnt);
		}else {
			if(!flag) return;
			getCnt(false, i + 1, cnt + 1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		mod = Integer.parseInt(in.readLine());
		n = Integer.parseInt(in.readLine());
		text = in.readLine();
		
		in.close();
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(text.charAt(i) == 'I') {
				count = 0;
				getCnt(true,i + 1,0);
				cnt += count;				
			}
		}
		
		System.out.print(cnt);
	}

}
