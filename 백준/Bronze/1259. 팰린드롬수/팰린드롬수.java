import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String num = in.readLine();
		
		while(!num.equals("0")) {
			char[] numArr = num.toCharArray();
			int len = numArr.length;
			boolean flag = false;
			for(int i = 0; i < len/2; i++) {
				if(numArr[i] != numArr[len - 1 - i]) {
					flag = true;
					break;
				}
			}
			if(flag) {
				sb.append("no\n");
			}else {
				sb.append("yes\n");
			}
			num = in.readLine();
		}
		
		System.out.print(sb);
		
	}
	

}