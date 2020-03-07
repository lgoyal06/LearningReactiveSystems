package flow.api.basics.nonblocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;

public class NumberPublisher implements Flow.Publisher<Long> {

    private ExecutorService executorService = Executors.newFixedThreadPool(20);

    @Override
    public void subscribe(Flow.Subscriber<? super Long> subscriber) {
        subscriber.onSubscribe(new NumberSubscription(executorService, subscriber));
    }
}
