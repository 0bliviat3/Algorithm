import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ4963Sol().run();
    }
}

class BOJ4963Sol {
    private static final String SEA = "0";
    private static final String END = "0 0";
    private static final int[][] move = 
    { 
        { 0, 1 },
        { 0, -1 },
        { 1, 0 },
        { -1, 0 },
        { 1, 1 },
        { -1, -1 },
        { 1, -1 },
        { -1, 1 } 
    };
    private boolean[][] visit;

    private void clear(int w, int h) {
        visit = new boolean[w][h];
    }

    private void init(String input, int i, int h) {
        StringTokenizer st = new StringTokenizer(input);
        for (int j = 0; j < h; j++) {
            visit[i][j] = st.nextToken().equals(SEA);
        }
    }

    private void dfs(int w, int h, int x, int y) {
        if (visit[x][y]) {
            return;
        }
        visit[x][y] = true;
        for(int i = 0; i < 8; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            if(dx < 0 || dy < 0 || dx >= w || dy >= h) {
                continue;
            }
            dfs(w, h, dx, dy);
        }
    }

    private int countLand(int w, int h) {
        int cnt = 0;
        for(int x = 0; x < w; x++) {
            for(int y = 0; y < h; y++) {
                if(!visit[x][y]) {
                    cnt++;
                    dfs(w, h, x, y);
                }
            }
        }
        return cnt;
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String input = null;
        while(!(input = in.readLine()).equals(END)) {
            StringTokenizer st = new StringTokenizer(input);
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            clear(w, h);
            for(int i = 0; i < w; i++) {
                init(in.readLine(), i, h);
            }

            ans.append(countLand(w, h)).append('\n');
        }
        System.out.print(ans);
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
