import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Set<Point> range = new HashSet<>();
		int n = Integer.parseInt(in.readLine());
		while(n-- >0) {
			st = new StringTokenizer(in.readLine()," ");		
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int m = 10;
			int m2 = 10;
			int tempX = x;
			while(m2-- >0) {
				while(m-- >0) {
					Point p = new Point(x,y);
					x++;				
					range.add(p);
				}
				y++;
				x = tempX;
				m = 10;
			}
			
		}
		sb.append(range.size());
		System.out.print(sb);
	}

}