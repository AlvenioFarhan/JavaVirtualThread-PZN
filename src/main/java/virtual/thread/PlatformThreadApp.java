package virtual.thread;

import java.time.Duration;

public class PlatformThreadApp {
    public static void main(String[] args) {
        for (int index = 0; index < 10; index++) {
            Thread thread = Thread.ofPlatform().name("alvenio-" + index).daemon(false).unstarted(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(2));
                    System.out.println("Hello " + Thread.currentThread() + "!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            thread.start();
        }
    }
}
