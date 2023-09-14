import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] arr = new int[12];
	
	static void plusCnt() {
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i  = 4; i < 11; i++) {
			arr[i] = arr[i - 1] + arr [i - 2] + arr[i - 3];
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		
		plusCnt();
		
		while(t-- > 0) {
			sb.append(arr[Integer.parseInt(in.readLine())] + "\n");
		}
		
		in.close();
		
		System.out.print(sb);
	}

}
