
import java.util.Scanner;
import java.util.Stack;

public class Advanced_week1_q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solver bot = null;
        int gameMode = 1;
        System.out.println("Please select game mode!");
        System.out.println("1. 1 vs 1\n2. 1 vs bot");
        System.out.print("1 or 2? ");
        gameMode = in.nextInt();
        while (true) {
            char[] ans, guess;
            int bull = 0;
            int cow = 0;
            System.out.print("Player 1: Please enter a secret number: ");
            ans = String.valueOf(in.next()).toCharArray();
            if (gameMode != 1) {
                bot = new Solver(ans.length);
            }
            int round = 1;
            while (true) {
                System.out.print("Player 2: Please guess the secret number(" + ans.length + " digit): ");
                if (gameMode == 1) {
                    guess = String.valueOf(in.next()).toCharArray();
                } else {
                    String temp = bot.guess(bull, cow);
                    guess = temp.toCharArray();
                    System.out.println(guess);
                }
                bull = 0;
                cow = 0;
                boolean[] isBull = new boolean[ans.length];
                for (int gIndex = 0; gIndex < ans.length; gIndex++) {
                    boolean rightNum = false;
                    boolean rightPlace = false;
                    for (int aIndex = 0; aIndex < ans.length; aIndex++) {
                        if (guess[gIndex] == ans[aIndex]) {
                            rightNum = true;
                            if (gIndex == aIndex) {
                                rightPlace = true;
                                bull++;
                                isBull[aIndex] = true;
                                break;
                            }
                        }
                    }
                    if (rightNum && !rightPlace) {
                        cow++;
                    }
                }
                if (bull == ans.length) {
                    System.out.println("Player 2: Correct! The secret number is " + String.valueOf(ans) + ".");
                    System.out.println("Total round(s): " + round);
                    break;
                } else {
                    System.out.println("Player 2: " + bull + " bull(s) " + cow + " cow(s). Try again!");
                    round++;
                }
            }
            System.out.print("Play again?(y/n) ");
            if (!in.next().equals("y")) {
                break;
            }
        }
    }

}

class Solver {

    int digit, counter, pos, firstBull;
    String ans, guess;
    Stack numStack;
    boolean[] correct;

    public Solver(int digit) {
        this.digit = digit;
        counter = -1;
        pos = -1;
        guess = "";
        numStack = new Stack();
        correct = new boolean[digit];
    }

    public String guess(int bull, int cow) {
        if (counter < 10 && numStack.size() < digit) {
            if (bull >= 1) {
                for (int i = 0; i < bull; i++) {
                    numStack.push(counter);
                }
            }
            if (numStack.size() < digit) {
                counter++;
                guess = "";
                for (int i = 0; i < digit; i++) {
                    guess += counter;
                }
            } else {
                counter = 10;
            }
        }
        if (counter >= 10) {
            if (ans == null) {
                ans = guess;
                while (numStack.pop().equals(numStack.peek())) {
                }
                firstBull = bull;
            }
            char[] temp = guess.toCharArray();
            char[] temp2 = ans.toCharArray();
            if (bull > firstBull) {
                temp2[pos] = temp[pos];
                correct[pos] = true;
                pos = 0;
                numStack.pop();
                firstBull++;
            } else if (bull < firstBull) {
                temp[pos] = temp2[pos];
                correct[pos] = true;
                pos++;
            } else {
                pos++;
            }
            while (pos >= 0 && correct[pos]) {
                pos++;
            }
            temp[pos] = (numStack.peek() + "").toCharArray()[0];
            guess = String.valueOf(temp);
            ans = String.valueOf(temp2);
        }
        return guess;
    }

}
