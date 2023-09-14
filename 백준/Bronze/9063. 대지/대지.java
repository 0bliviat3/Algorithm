import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int maxX = x;
		int minX = x;
		int maxY = y;
		int minY = y;
		while(--n > 0) {
			st = new StringTokenizer(in.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			maxX = (maxX<x) ? x : maxX;
			maxY = (maxY<y) ? y : maxY;
			minX = (minX>x) ? x : minX;
			minY = (minY>y) ? y : minY;
		}
		
		System.out.print((maxX - minX)*(maxY - minY));
	}
}