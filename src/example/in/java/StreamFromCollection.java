package example.in.java;

import java.util.Arrays;
import java.util.List;

/**
 * $author Kryzoo (mpe@touk.pl)
 * Date: 18.04.13 21:59
 */
public class StreamFromCollection {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ala", "Ela", "Mariola", "Staszek", "Franek", "Zygmunt", "Erni");

        String name5 = names.stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() < 5)
                .sorted((a, b) -> b.length() - a.length())
                .findFirst()
                .orElse("nie ma?");
        System.out.println(name5);

        String name2 = names.stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() < 2)
                .sorted((a, b) -> b.length() - a.length())
                .findFirst()
                .orElse("nie ma?");
        System.out.println(name2);

        List<Integer> liczby = Arrays.asList(5, 6, 3, 7, 1, 3, 4, 5, 4, 2, 1, 2, 3, 3);

        //reduce
        liczby.stream()
                .filter(s -> s % 2 != 0)
                .map(s -> s * 2)
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);

    }

}
