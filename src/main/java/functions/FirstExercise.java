package functions;

import java.util.Arrays;
import java.util.Scanner;

public class FirstExercise {

    public static void main(String[] args) {

        String line1 = "...soft windows oracle apple Apple zpple";
        String line2 = "apple Apple zpple windows oracle microsoft";
        String line3 = "zpplsde zeApple microsoft appleeee orac23le window1s";
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] words = line.split(" ", 7);
        Arrays.sort(words, (s1, s2) -> {
            int result = s2.length() - s1.length();
            if (result == 0) {
                result = s1.compareToIgnoreCase(s2);
            }
            return result;
        });
        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
