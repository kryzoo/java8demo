package example.in.java;

import java.util.function.Function;
import java.util.function.Supplier;

class LambdaReference {
    public static String gwiazdki(Integer value){
        if(value > 0){
            return '*' + gwiazdki(value - 1);
        }
        return "";
    }

    public String ramka(Integer value){
        String val = String.valueOf(value);
        StringBuilder builder = new StringBuilder();

        builder.append(gwiazdki(val.length() + 6)).append('\n');
        builder.append(gwiazdki(3)).append(val).append(gwiazdki(3)).append('\n');
        builder.append(gwiazdki(val.length() + 6)).append('\n');

        return builder.toString();
    }

    public void executeLambda(Function<Integer, String> lambda, Integer value){
        System.out.println(lambda.apply(value));
    }


    public static void main(String[] args) {
        LambdaReference instance = new LambdaReference();
        System.out.println("gwiazdki(static):");
        instance.executeLambda(LambdaReference::gwiazdki, 25);
        System.out.println("ramka(instance):");
        instance.executeLambda(instance::ramka, 999);

       /* List<String> names = Arrays.asList("Ala", "Ola", "Ela");
        names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println);*/

        //Costructor reference
        Supplier<LambdaReference> constructorReference = LambdaReference::new;
        LambdaReference lambdaReference = constructorReference.get();
        instance.executeLambda(lambdaReference::ramka, 1000000);


/*        Supplier<ArrayList<String>> listSupplier = ArrayList<String>::new;
        ArrayList<String> list = listSupplier.get();
        System.out.println(list.size());*/

    }
}
