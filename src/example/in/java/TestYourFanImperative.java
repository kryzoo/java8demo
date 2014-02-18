package example.in.java;

class TestYourFanImperative{

    public static void main(String[] args) {

        for (int i=0; i < 16; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) ;
                }
            }).start();
        }
    }

}
