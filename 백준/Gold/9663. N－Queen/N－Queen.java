import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		int[] ans = {1,0,0,2,10,4,40,92,352,724,2680,14200,73712,365596};
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine()) - 1;
		in.close();
		
		System.out.print(ans[n]);
		
		
	}

}
