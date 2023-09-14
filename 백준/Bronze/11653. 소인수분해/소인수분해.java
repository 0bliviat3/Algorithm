import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		in.close();
		int i = 2;
		while((i*i)<=n) {
			while(n%i == 0) {
				n/=i;
				sb.append(i+"\n");
			}
			i++;			
		}
		if(n>1) {
			sb.append(n);
		}
		System.out.print(sb);

	}

}