import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> score = new HashMap<>();
        score.put("A+", 4.3d);
        score.put("A0", 4.0d);
        score.put("A-", 3.7d);
        score.put("B+", 3.3d);
        score.put("B0", 3.0d);
        score.put("B-", 2.7d);
        score.put("C+", 2.3d);
        score.put("C0", 2.0d);
        score.put("C-", 1.7d);
        score.put("D+", 1.3d);
        score.put("D0", 1.0d);
        score.put("D-", 0.7d);
        score.put("F", 0.0d);
        System.out.print(score.get(in.readLine()));
    }    
}

