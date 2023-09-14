import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10];
		int n = 3;
		int mul = 1;
		while(n-- >0) {
			int temp = Integer.parseInt(in.readLine());
			mul*=temp;
		}
		in.close();
		String mulStr = String.valueOf(mul);
		for(int i=0;i<mulStr.length();i++) {
			int now = Integer.parseInt(String.valueOf(mulStr.charAt(i)));
			arr[now]++;
		}
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.print(sb);
	}

}