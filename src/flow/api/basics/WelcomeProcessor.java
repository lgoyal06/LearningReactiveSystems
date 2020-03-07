package flow.api.basics;

import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Predicate;

public class WelcomeProcessor<T> extends SubmissionPublisher<T> implements Processor<T, T> {


    private Predicate<? super T> filter;

    public WelcomeProcessor(Predicate<? super T> filter) {
        this.filter = filter;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        System.out.println("Processor received: " + item);
        if (filter.test(item)) {
            this.submit(item);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Processor os complete.");
        this.close();
    }
}
