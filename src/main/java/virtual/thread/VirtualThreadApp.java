package virtual.thread;

import java.io.IOException;
import java.time.Duration;

public class VirtualThreadApp {
    public static void main(String[] args) throws IOException {
        for (int index = 0; index < 10000; index++) {
            Thread thread = Thread.ofVirtual().name("alvenio-" + index).unstarted(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(2));
                    System.out.println("Hello " + Thread.currentThread() + "!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            thread.start();
        }
        System.in.read();
    }
}
