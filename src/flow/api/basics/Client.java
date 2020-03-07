package flow.api.basics;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.LongStream;

public class Client {

    public static void main(String... s) throws InterruptedException {
        SubmissionPublisher<Long> publisher = new SubmissionPublisher<>();
        int count = 5;
        WelcomeSubscriber subscriber = new WelcomeSubscriber(count);
        publisher.subscribe(subscriber);
        LongStream.range(10, 20).forEach(publisher::submit);
        Thread.sleep(1000);
    }
}
