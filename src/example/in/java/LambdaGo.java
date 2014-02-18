package example.in.java;

class LambdaGo {
    interface IntegerFunction {
        Integer calc(Integer i);
    }

    static void wypiszWynikFunkcji(IntegerFunction funkcja, Integer arg){
        System.out.println(funkcja.calc(arg));
    }


    public static void main(String[] args) {

        /*
                 * Tak było do tej pory
                 */

        wypiszWynikFunkcji(new IntegerFunction() {
            @Override
            public Integer calc(Integer i) {
                return 2 * i;
            }
        }, 21);

        wypiszWynikFunkcji(new IntegerFunction() {
            @Override
            public Integer calc(Integer i) {
                return 2 + i;
            }
        }, 21);



        /*
                  *  Tak jest po nowemu
                  */

        wypiszWynikFunkcji((Integer x) -> 2 * x, 21);
        wypiszWynikFunkcji(x -> 2 + x, 21);


    //ciekawostka: czy lambda jest objektem?
        Runnable r = () -> {};
        Object o = r;
        System.out.println(o);

        Runnable r1 = () -> {};
        System.out.println(r1);
        System.out.println(r.equals(r1));

    }
}
