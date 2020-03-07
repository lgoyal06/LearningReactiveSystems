package flow.api.basics;

import java.util.concurrent.SubmissionPublisher;
import java.util.stream.LongStream;

public class MainClassProcessorTest {

    public static void main(String... s) throws InterruptedException {
        SubmissionPublisher<Long> publisher = new SubmissionPublisher<>();
        int count = 5;
        WelcomeSubscriber subscriber = new WelcomeSubscriber(count);
        WelcomeProcessor<Long> processor = new WelcomeProcessor<>(n -> n % 5 == 0);
        publisher.subscribe(processor);
        processor.subscribe(subscriber);
        LongStream.range(10, 60).forEach(publisher::submit);
        Thread.sleep(10000);

    }
}
