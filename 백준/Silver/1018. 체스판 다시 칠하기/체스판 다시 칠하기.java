import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] all = new char[n][m];
		for(int i = 0; i < n; i++) {
			all[i] = in.readLine().toCharArray();
		}
		in.close();
		char[][] p1 = {
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'}
		};
		char[][] p2 = {
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'}
		};
		int n2 = n - 8;
		int m2 = m - 8;
		int cnt1 = 0;
		int cnt2 = 0;
		int min = 1000000000;
		for(int k = 0; k <= n2; k++) {
			for(int l = 0; l <= m2; l++) {
				cnt1 = 0;
				cnt2 = 0;
				for(int i = 0; i < 8; i++) {
					for(int j = 0; j < 8; j++) {
						if(all[k+i][l+j] != p1[i][j]) {
							cnt1++;
						}
						if(all[k+i][l+j] != p2[i][j]) {
							cnt2++;
						}
					}
				}
				cnt1 = (cnt1>=cnt2) ? cnt2 : cnt1;
				if(min > cnt1) {
					min = cnt1;
				}			
			}
		}
		System.out.print(min);
	}

}
