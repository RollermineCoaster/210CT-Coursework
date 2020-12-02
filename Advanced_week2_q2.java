
import java.util.Scanner;

public class Advanced_week2_q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] parmTitle = {"loan amount", "loan term in years", "interest rate"};
        double[] parm = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Please enter " + parmTitle[i] + ": ");
            parm[i] = in.nextDouble();
        }
        double la = parm[0];
        double lt = parm[1];
        double ir = parm[2];
        double payback = la * (ir / 12 * Math.pow(1 + ir / 12, lt * 12) / (Math.pow(1 + ir / 12, lt * 12) - 1));
        System.out.println("Monthly pay back: " + payback);
    }
}
