import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] winner = new String[]{"ITMO", "SPbSU", "SPbSU", "ITMO", "ITMO",
                               "SPbSU", "ITMO", "ITMO", "ITMO", "ITMO",
                               "ITMO", "PetrSU, ITMO", "SPbSU", "SPbSU",
                               "ITMO", "ITMO", "ITMO", "ITMO", "SPbSU",
                               "ITMO", "ITMO", "ITMO", "ITMO", "SPbSU", "ITMO"};
        final int val = 1995;
        
        System.out.print(winner[Integer.parseInt(in.readLine()) - val]);
    }
}