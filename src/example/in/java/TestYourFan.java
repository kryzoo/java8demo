package example.in.java;

import java.util.stream.Streams;

class TestYourFan {

    public static void main(String[] args) {

        Streams.intRange(1, 16).forEach(
                (i) -> new Thread(
                    () -> { while(true); }
                ).start());
    }
}
