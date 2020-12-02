
import java.util.Scanner;

public class Advanced_week2_q3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the N: ");
        int n = in.nextInt();
        double ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += 1.0 / i;
        }
        System.out.println("The nth value of the harmonic series is " + ans);
    }
}
