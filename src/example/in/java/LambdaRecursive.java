package example.in.java;

import java.util.function.UnaryOperator;

class LambdaRecursive {

    static UnaryOperator<Integer> factorial;

    public static void main(String[] args) {

        factorial = i -> i == 0 ? 1 : i * factorial.apply( i - 1 );

        System.out.println(factorial.apply(6));

    }
}
