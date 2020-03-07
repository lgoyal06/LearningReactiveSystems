package flow.api.basics.nonblocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;
import java.util.concurrent.Future;
import java.util.stream.LongStream;

public class NumberSubscription implements Flow.Subscription {

    private final ExecutorService executorService;
    private Flow.Subscriber<? super Long> subscriber;
    Future<?> future;

    public NumberSubscription(ExecutorService executorService, Flow.Subscriber<? super Long> subscriber) {
        this.executorService = executorService;
        this.subscriber = subscriber;
    }

    @Override
    public void request(long n) {
        subscriber.onNext(10l);
    }

    @Override
    public void cancel() {
        executorService.shutdown();
        System.out.println("Shutting down");
        future.cancel(true);
    }
}
