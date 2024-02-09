import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ20303Sol().run();
    }
}

class BOJ20303Sol {
    /*
     * 연결된 애기들 그룹으로 묶음 Union-find
     * 1명부터 k - 1명까지 애기들 학살할때의 최대 사탕수 저장
     */

    private int[] parents;
    private int[] candys; // union시 부모노드에 해당하는 사탕의수 갱신
    private int[] cryBabys; // 우는 애들수 : idx, 최대 사탕수 : val
    private int[] groupTO; // 그룹 인원수
    private int n, m ,k;

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }

    private void clear() {
        parents = new int[n + 1];
        candys = new int[n + 1];
        groupTO = new int[n + 1];
        cryBabys = new int[k];
        for(int i = 1; i <= n; i++) {
            parents[i] = i;
            groupTO[i] = 1;
        }
    }

    private void initCandy(String input) {
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 1; i <= n; i++) {
            candys[i] = Integer.parseInt(st.nextToken());
        }
    }

    private int getParent(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x] = getParent(parents[x]);
    }

    private boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a == b) {
            return false;
        }else if(a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
        return true;
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        init(in.readLine());
        clear();
        initCandy(in.readLine());
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    private void setGroup() {
        for(int i = 1; i <= n; i++) {
            if(parents[i] != i) {
                int parent = getParent(i);
                candys[parent] += candys[i];
                groupTO[parent] += groupTO[i];
            }
        }
    }

    private void maxCandy() {
        setGroup();
        for(int j = 1; j <= n; j++) {
            if(parents[j] != j) {
                continue;
            }
            int TO = groupTO[j];
            int candy = candys[j];
            for(int i = k - 1; i >= TO; i--) {
                cryBabys[i] = Math.max(cryBabys[i], cryBabys[i - TO] + candy);
            }
        }
        System.out.print(cryBabys[k - 1]);
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        maxCandy();
    }
}
