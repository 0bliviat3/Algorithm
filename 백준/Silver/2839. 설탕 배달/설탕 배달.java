import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();
		
		int result = 0;
		int mod = n%5;
		if(mod == 0) {
			result = n/5;
		}else if(mod == 3) {
			result = n/5 + 1;
		}else if(mod == 1) {
			if(n>=6) {
				result = (n - 6)/5 + 2;
			}else {
				result = -1;
			}
		}else if(mod == 2) {
			if(n>=12) {
				result = (n-12)/5 + 4;
			}else {
				result = -1;
			}
		}else if(mod == 4) {
			if(n>=9) {
				result = (n-9)/5 + 3;
			}else {
				result = -1;
			}
		}
		
		System.out.print(result);
	}

}