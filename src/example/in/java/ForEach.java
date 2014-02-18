package example.in.java;

import java.util.Arrays;
import java.util.List;

/**
 * $author Kryzoo (mpe@touk.pl)
 * Date: 03.04.13 23:23
 */
public class ForEach {
    public static void main(String[] args) {

        List<String> friends = Arrays.asList("Atos", "Portos", "Aramis", "D'Artagnan");

        //external iterate with index == evil
        for(int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        //external iterate on collection, better but ... external
        for(String friend : friends){
            System.out.println(friend);
        }

        //lambda
        friends.forEach(s -> System.out.println(s));

        //lambda reference
        friends.forEach(System.out::println);
    }

}
