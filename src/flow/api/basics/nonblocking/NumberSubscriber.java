package flow.api.basics.nonblocking;

import java.util.concurrent.Flow;

public class NumberSubscriber implements Flow.Subscriber<Long> {

    Flow.Subscription subscription;
    int counter = 5;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Long item) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (--counter > 0) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "item is :  " + item);
            }
            subscription.request(1);
        } else {
            subscription.cancel();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error occurred" + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }
}
