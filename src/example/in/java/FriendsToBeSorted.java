package example.in.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * $author Kryzoo (mpe@touk.pl)
 * Date: 03.04.13 23:23
 */
public class FriendsToBeSorted {

    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Atos", "Portos", "Aramis", "D'Artagnan");

        //just sort using lambda comparator
        System.out.println("sort:");
        friends.stream().sorted((aName, bName) -> aName.compareTo(bName))
            .forEach(System.out::println);

        //Uwaga, niespodzianka

        friends.stream().sorted(String::compareTo)
                .forEach(System.out::println);


        //same but reverse
        System.out.println("\nsort reverse:");
        Comparator<String> comp = (aName, bName) -> aName.compareTo(bName);

        friends.stream().sorted(comp.reverseOrder())
            .forEach(System.out::println);

        //tak się to robiło kiedyś
        //mutable evil!
        System.out.println("\nmutable sort:");
        friends.sort(comp);
        friends.forEach(System.out::println);

        //comparator by length
        System.out.println("\nsort by length:");
        Comparator<String> compByLength = (aName, bName) -> aName.length() - bName.length();
        friends.stream().sorted(compByLength).forEach(System.out::println);

        //longest name
        friends.stream().max(compByLength)
                .ifPresent(longest -> System.out.println("\nThe longest name is " + longest));
    }


}
