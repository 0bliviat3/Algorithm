import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		in.close();
		
		int up = Integer.parseInt(arr[1]) * Integer.parseInt(arr[3]);
		up -= Integer.parseInt(arr[4]) * Integer.parseInt(arr[0]);
		int mod = Integer.parseInt(arr[2]) * Integer.parseInt(arr[3]);
		mod -= Integer.parseInt(arr[5]) * Integer.parseInt(arr[0]);
		int x = 0;
		int y = 0;
		if(mod != 0 && up != 0) {
			y = mod/up;
		}
		if(arr[0].equals("0")) {
			x = (Integer.parseInt(arr[5]) - Integer.parseInt(arr[4]) * y)/Integer.parseInt(arr[3]);			
		}else {
			x = (Integer.parseInt(arr[2]) - Integer.parseInt(arr[1]) * y)/Integer.parseInt(arr[0]);			
		}
		StringBuilder sb = new StringBuilder();
		sb.append(x + " " + y);
		System.out.print(sb);
	}

}