import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		Set<Point> pointSet = new HashSet<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = 4;
		while(n-- >0) {
			st = new StringTokenizer(in.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i = x1; i < x2; i++) {
				for(int j = y1; j < y2; j++) {
					Point p = new Point(i,j);
					pointSet.add(p);
				}
			}
		}
		in.close();
		System.out.print(pointSet.size());
	}

}