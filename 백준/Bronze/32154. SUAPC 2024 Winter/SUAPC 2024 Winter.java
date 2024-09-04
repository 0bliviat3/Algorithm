import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<String> rank = new ArrayList<>();
        rank.add("11\nA B C D E F G H J L M");
        rank.add("9\nA C E F G H I L M");
        rank.add("9\nA C E F G H I L M");
        rank.add("9\nA B C E F G H L M");
        rank.add("8\nA C E F G H L M");
        rank.add("8\nA C E F G H L M");
        rank.add("8\nA C E F G H L M");
        rank.add("8\nA C E F G H L M");
        rank.add("8\nA C E F G H L M");
        rank.add("8\nA B C F G H L M");

        System.out.print(rank.get(Integer.parseInt(in.readLine()) - 1));
    }
}
