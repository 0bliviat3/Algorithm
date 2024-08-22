import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] score = new int[2];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            score[i] += Integer.parseInt(st.nextToken()) * 6;
            score[i] += Integer.parseInt(st.nextToken()) * 3;
            score[i] += Integer.parseInt(st.nextToken()) * 2;
            score[i] += Integer.parseInt(st.nextToken()) * 1;
            score[i] += Integer.parseInt(st.nextToken()) * 2;
        }

        System.out.print(score[0] + " " + score[1]);
    }
}
