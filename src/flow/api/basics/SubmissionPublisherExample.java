package flow.api.basics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.LongStream;

public class SubmissionPublisherExample {


    public static void publish() throws InterruptedException, ExecutionException {
        CompletableFuture future = null;
        try (SubmissionPublisher<Long> submissionPublisher = new SubmissionPublisher<>()) {
            future = submissionPublisher.consume(System.out::println);
            LongStream.range(10, 20).forEach(submissionPublisher::submit);
        } finally {
            future.get();
        }
    }

    public static void main(String... s) throws ExecutionException, InterruptedException {
        publish();
    }
}
