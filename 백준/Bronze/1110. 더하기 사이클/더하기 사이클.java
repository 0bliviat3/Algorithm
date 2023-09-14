import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(in.readLine());
		in.close();
		int now = number;
		int cnt = 0;
		do {
			if(now < 10) {
				now+=now*10;
			}else {
				int temp = now/10 + now%10;
				now = now%10*10 + temp%10;
			}
			cnt++;
		}while(now != number);
		
		System.out.print(cnt);
	}

}