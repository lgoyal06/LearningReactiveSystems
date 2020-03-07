package flow.api.basics;

import java.util.concurrent.Flow.*;

public class WelcomeSubscriber implements Subscriber<Long> {


    private Subscription subscription;
    private final long maxCount;
    private long counter;

    public WelcomeSubscriber(long maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println(Thread.currentThread().getName() + "subscribed with max count ::" + maxCount);
        subscription.request(maxCount);
    }

    @Override
    public void onNext(Long item) {
        counter++;
        System.out.println(Thread.currentThread().getName() + " received :" + item);
        if (counter >= maxCount) {
            System.out.println("Cancelling processed item count:" + counter);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println(Thread.currentThread().getName() + " got Completed");
    }
}
