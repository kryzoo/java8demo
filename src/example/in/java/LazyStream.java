package example.in.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * $author Kryzoo (mpe@touk.pl)
 * Date: 18.04.13 21:59
 */
public class LazyStream {



    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ala", "Ela", "Mariola", "Staszek", "Franek", "Zygmunt", "Erni");


/*
        String name5 = names.stream()
                .map(LazyStream::toUpperCase)
                .filter(LazyStream::greaterThanFive)
                .limit(2)
                .collect(Collectors.toStringJoiner(" + ")).toString() + " = WSM!!!";

        System.out.println(name5);
*/

        Stream<String> s1 = names.stream()
                .map(LazyStream::toUpperCase);
        Stream<String> s2 = s1.filter(LazyStream::greaterThanFive);
        Stream<String> s3 = s2.limit(2);
        System.out.println(s3.collect(Collectors.toStringJoiner(" + ")).toString() + " = WSM!!!");

/*
        String name5b = names.stream()
                .map(LazyStream::toUpperCase)
                .filter(LazyStream::greaterThanFive)
                .limit(2).findFirst().orElse("nic");


        System.out.println(name5b);
*/
    }

    private static String toUpperCase(String s) {
        System.out.println("toUpperCase: " + s);
        return s.toUpperCase();
    }

    private static boolean greaterThanFive(String s) {
        System.out.println("greaterThanFive: " + s);
        return s.length() > 5;
    }
}
