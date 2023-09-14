import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringBuilder rsb = new StringBuilder();
		while(t-- > 0) {
			String now = in.readLine();
			int len = now.length();
			int prime = (int) Math.ceil(len/(double)3);
			String nowPrime = now.substring(0,prime);
			String rev = rsb.append(nowPrime).reverse().toString();
			if(now.equals(nowPrime + rev + nowPrime)) {
				sb.append(1+"\n");
			}else if(now.equals(nowPrime + rev.substring(1) + nowPrime)) {
				sb.append(1+"\n");
			}else if(now.equals(nowPrime + rev + nowPrime.substring(1))) {
				sb.append(1+"\n");
			}else if(now.equals(nowPrime + rev.substring(1) + nowPrime.substring(1))) {
				sb.append(1+"\n");
			}else {
				sb.append(0 + "\n");
			}
			rsb.delete(0, prime);
		}
		
        in.close();
        
		System.out.print(sb);
	}

}