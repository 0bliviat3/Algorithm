import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		in.close();
		
		int sum = 0;
		int last = 0;
		while(n >= m && n != 1) {
			boolean flag = false;
			for(int i=2;i<=n;i++) {
				if(n%i == 0 && i != n) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				sum+=n;
				last = n;
			}
			n--;
		}
		if(sum == 0) {
			sb.append(-1);
		}else {
			sb.append(sum+"\n");
			sb.append(last);
		}
		System.out.print(sb);

	}

}