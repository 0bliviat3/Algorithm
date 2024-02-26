import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        new BOJ2143Sol().run();
    }
}

class BOJ2143Sol {
    /*
     * 각 배열의 누적합 모두 구해서 저장
     * 이때 중복되는 누적합은 count
     * 누적합배열 정렬
     * 정렬안한 배열의 원소하나와 정렬한 누적합 배열로 이진 탐색
     * 이때 누적합의 개수로 count
     * 일치할경우, a배열의 누적합의 개수 * b배열의 누적합의 개수
     * 정렬안한 배열 모두 순회하며 개수 count
     */

    private Map<Integer, Long> sumA;
    private Map<Integer, Long> sumB;
    private int[] arrA;
    private int[] arrB;
    private int target, n, m;
    private long ans;

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clear();
        setA();
        setB();
        setAns();
        System.out.print(ans);
    }

    private void clear() {
        sumA = new TreeMap<>();
        sumB = new HashMap<>();
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(in.readLine());
        n = Integer.parseInt(in.readLine());
        arrA = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(in.readLine());
        arrB = new int[m];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void setA() {
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arrA[j];
                sumA.put(sum, sumA.getOrDefault(sum, 0L) + 1);
            }
        }
    }

    private void setB() {
        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = i; j < m; j++) {
                sum += arrB[j];
                sumB.put(sum, sumB.getOrDefault(sum, 0L) + 1);
            }
        }
    }

    private void setAns() {
        List<Integer> sortA = new ArrayList<>(sumA.keySet());
        sumB.forEach((k, v) -> {
            int judge = Collections.binarySearch(sortA, target - k);
            if(judge >= 0) {
                ans += v * sumA.get(target - k);
            }
        });
    }

}
