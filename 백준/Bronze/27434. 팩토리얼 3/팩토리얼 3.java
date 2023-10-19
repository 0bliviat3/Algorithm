import java.io.*;
import java.math.*;

public class Main {
    
    static BigInteger factorial(int a, int num) {
		BigInteger result = BigInteger.valueOf(a);
		if(a < num) {
			int b = (a + num) / 2;
			result= factorial(a,b).multiply(factorial(b + 1,num));
		}
		return result;
	}
   
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        in.close();
		
        System.out.print(factorial(1,n));
        
    }
}