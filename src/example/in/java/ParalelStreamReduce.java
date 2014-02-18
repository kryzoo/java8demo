package example.in.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

class ParalelStreamReduce {

    public static void main(String[] args) {
        List<Integer> liczby = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.println("Reducer (a,b) -> (a+b)");
        compareStreams(liczby, (a,  b) -> (a + b));

        System.out.println("Reducer (a,b) -> (a-b)");
        compareStreams(liczby, (a,  b) -> (a - b));

    }

    private static void compareStreams(List<Integer> liczby, BinaryOperator<Integer> reducer) {
        int sum1 = liczby.stream()
                .reduce(0, reducer);

        int sum2 = liczby.parallelStream()
                .reduce(0, reducer);

        System.out.printf("stream: %d\nparallelstream: %d\n", sum1, sum2);

        if(sum1 != sum2){
            System.out.println("ERROR!!!!!");
        }
    }
}
