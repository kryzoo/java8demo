package example.in.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Streams;

/**
 * $author Kryzoo (mpe@touk.pl)
 * Date: 18.04.13 21:59
 */
public class GoParallel {


    public static void main(String[] args) {

        List<Integer> liczby = Arrays.asList(4,3,5,7,2,2,3,5);

        liczby.stream()
                .reduce((a, b) -> a + b).ifPresent(System.out::println);

        liczby.parallelStream()
                .reduce((a, b) -> a + b).ifPresent(System.out::println);

        System.out.println("isParallel liczby.stream(): "
                + liczby.stream().isParallel());

        System.out.println("isParallel liczby.stream().parallel(): "
                + liczby.stream().parallel().isParallel());

        System.out.println("isParallel liczby.parallelStream(): "
                + liczby.parallelStream().isParallel());

        System.out.println("isParallel liczby.parallelStream().sequential(): "
                + liczby.parallelStream().sequential().isParallel());

        long first = System.currentTimeMillis();
        Streams.intRange(0, 4)
                .map(a -> {
                    sleep1sec();
                    return a;
                })
                .reduce((a, b) -> a * b)
                .ifPresent(System.out::println);


        long second = System.currentTimeMillis();
        System.out.println("time 1:" + (second -  first));

        Streams.intRange(0, 4).parallel()
                .map(a -> {
                    sleep1sec();
                    return a;
                })
                .reduce((a, b) -> a * b)
                .ifPresent(System.out::println);

        long last = System.currentTimeMillis();
        System.out.println("time 2:" + (last - second));

    }

    private static void sleep1sec() {
        try {Thread.sleep(1000);} catch (InterruptedException e) {}
    }
}
