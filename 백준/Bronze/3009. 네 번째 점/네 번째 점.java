import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] point = in.readLine().split(" ");
		String[] point2 = in.readLine().split(" ");
		String[] point3 = in.readLine().split(" ");
		in.close();
		for(int i = 0; i<2; i++) {
			if(point[i].equals(point2[i])) {
				sb.append(point3[i] + " ");
			}else if(point[i].equals(point3[i])) {
				sb.append(point2[i] + " ");
			}else {
				sb.append(point[i] + " ");
			}			
		}
				
		System.out.print(sb);
	}

}