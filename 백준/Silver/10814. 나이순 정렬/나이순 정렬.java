import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		
		Member[] mArr = new Member[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			Member m = new Member();
			m.age = Integer.parseInt(st.nextToken());
			m.name = st.nextToken();
			mArr[i] = m;
		}
		
		in.close();
		
		Arrays.sort(mArr);
		
		for(int i = 0; i < n; i++) {
			out.write(mArr[i].age + " " + mArr[i].name + "\n");
		}
		
		out.flush();
		out.close();
	}

}

class Member implements Comparable<Member>{
	int age = 0;
	String name = null;
	@Override
	public int compareTo(Member o) {
		return this.age - o.age;
	}
	
}
