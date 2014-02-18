package example.in.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * $author Kryzoo (mpe@touk.pl)
 * Date: 03.04.13 23:23
 */
public class Friends {
    public static void main(String[] args) {

        List<String> friends = Arrays.asList("Atos", "Portos", "Aramis", "D'Artagnan");

        // a bit redundant
/*
        System.out.println("A1:");
        friends.stream().filter((a) -> a.startsWith("A"))
                .forEach(System.out::println);

        System.out.println("P1:");
        friends.stream().filter((a) -> a.startsWith("P"))
                .forEach(System.out::println);
*/

        final Function<String, Predicate<String>> startsWith =
                letter -> name -> name.startsWith(letter);

        System.out.print("A2:");
        friends.stream().filter(startsWith.apply("A"))
                .forEach(System.out::println);

        System.out.print("P2:");
        friends.stream().filter(startsWith.apply("P"))
                .forEach(System.out::println);

        String prefixA = "A";
        System.out.println("A3: " +
            friends.stream().filter(name -> startsWithLetter(prefixA, name))
                    .collect(Collectors.toStringJoiner(", ")));

        String prefixP = "P";
        System.out.println("P3: " +
            friends.stream().filter(name -> startsWithLetter(prefixP, name))
                    .collect(Collectors.toStringJoiner(", ")));

        System.out.print("All gays: ");
        System.out.println(friends.stream().collect(Collectors.toStringJoiner(", ")));
    }

    private static boolean startsWithLetter(String a, String name) {
        return name.startsWith(a);
    }

}
