import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] sudoku = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		in.close();
		
		pro(0,0);
	}
	
	static void build() { // 출력
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	static boolean chk(int row, int col , int val) { // 유효성 체크
		
		for(int i = 0; i < 9; i++) { // 현재 행,열에서 채워진 부분 제외
			if(sudoku[i][col] == val) return false;
			if(sudoku[row][i] == val) return false;
		}
		
		int nowRow = row/3*3;
		int nowCol = col/3*3;
		
		for(int i = nowRow; i < nowRow + 3; i++) { // 현재 3X3 에서 채워진 부분 제외
			for(int j = nowCol; j < nowCol + 3; j++) {
				if(sudoku[i][j] == val) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	static void init(int row, int col, boolean flag) {
		for(int i = 1; i <= 9; i++) {
			if(sudoku[row][col] == 0 && chk(row,col,i)) {
				sudoku[row][col] = i;
				if(flag) {
					pro(0, col + 1);					
				}else {
					pro(row + 1, col);
				}
				// build가 호출되지 않은 상황.. 즉 스도쿠가 틀렸으므로 현재 칸을 빈칸으로 초기화
				// 이전 재귀로 돌아가게끔 한다.
				sudoku[row][col] = 0; // 초기화
			}
		}
	}
	
	static void pro(int row, int col) {
		if(col == 9) { // 작성
			build();
			System.exit(0);
		}
		
		if(row == 8) { // 줄바꿈
			init(row,col,true);
			if(sudoku[row][col] == 0) { // 이전 재귀로 돌아가서 다시 init의 반복문으로 돌아가 다른값을 받는다.
				return;
			}
			pro(0,col + 1); // 이후 제대로 된 값을 받은 경우 다음 칸으로 넘어간다.
		}else {
			init(row,col,false);
			if(sudoku[row][col] == 0) { // 또는 반복문을 다 돌았는데도 0인 경우 더 이전 재귀로 돌아가 다른값을 받는다.
				return;
			}
			pro(row + 1, col);
		}
	}

}
