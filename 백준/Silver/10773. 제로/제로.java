import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> stack = new ArrayList<>();
		int k = Integer.parseInt(in.readLine());
		int sum = 0;
		while(k-- >0) {
			int num = Integer.parseInt(in.readLine());
			if(num == 0) {
				if(stack.size() != 0) {
					stack.remove(stack.size()-1);					
				}
			}else {
				stack.add(num);
			}
		}
		in.close();
		for(int i=0; i<stack.size();i++) {
			sum += stack.get(i);
		}
		sb.append(sum);
		System.out.print(sb);

	}

}