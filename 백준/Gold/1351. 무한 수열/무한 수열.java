import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static HashMap<BigInteger,BigInteger> map = new HashMap<>();
	
	static BigInteger aArr(BigInteger n,BigInteger p,BigInteger q) {
		if(map.get(n) != null) return map.get(n);
		map.put(n, aArr(n.divide(p),p,q).add(aArr(n.divide(q),p,q)));
		return map.get(n);
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		map.put(new BigInteger("0"), new BigInteger("1"));
		
		BigInteger n = new BigInteger(st.nextToken());
		BigInteger p = new BigInteger(st.nextToken());
		BigInteger q = new BigInteger(st.nextToken());
		
		System.out.print(aArr(n,p,q));
	}

}
