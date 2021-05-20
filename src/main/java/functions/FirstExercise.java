package functions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstExercise {

    public static void main(String[] args) {

        String line1 = "...soft windows oracle apple Apple zpple";
        String line2 = "apple Apple zpple windows oracle microsoft";
        String line3 = "zpplsde zeApple microsoft appleeee orac23le window1s";
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] wordsArray = line.split(" ", 7);
        List<String> words = Arrays.asList(wordsArray);
        words.sort(String::compareToIgnoreCase);
        words.sort(Comparator.comparing(String::length).reversed());
        List<String> sortedWords = words.stream()
                .sorted(String::compareToIgnoreCase)
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        for(String word : sortedWords) {
            builder.append(word).append(" ");
        }
        builder.deleteCharAt(builder.lastIndexOf(" "));
        System.out.print(builder);
    }

    private static int biggerWord(String word1, String word2) {
        if (word1.compareToIgnoreCase(word2) == 0) {
            return word2.compareTo(word1);
        } else {
            return word1.compareTo(word2);
        }

    }
}
