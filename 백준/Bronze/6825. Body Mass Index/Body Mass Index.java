import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Double w = Double.parseDouble(in.readLine());
        Double h = Double.parseDouble(in.readLine());

        double bmi = w / (h * h);

        if (bmi > 25) {
            System.out.print("Overweight");
        } else if (bmi < 18.5D) {
            System.out.print("Underweight");
        } else {
            System.out.print("Normal weight");
        }
    }
}