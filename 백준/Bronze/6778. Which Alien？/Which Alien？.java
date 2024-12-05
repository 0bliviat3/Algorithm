import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int antenna = Integer.parseInt(in.readLine());
        int eyes = Integer.parseInt(in.readLine());

        StringBuilder ans = new StringBuilder();

        if (antenna >= 3 && eyes <= 4) {
            ans.append("TroyMartian\n");
        }
        if (antenna <= 6 && eyes >= 2) {
            ans.append("VladSaturnian\n");
        }
        if (antenna <= 2 && eyes <= 3) {
            ans.append("GraemeMercurian");
        }

        System.out.print(ans);
    }
}