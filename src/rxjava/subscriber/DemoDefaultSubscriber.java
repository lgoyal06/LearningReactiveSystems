package rxjava.subscriber;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DefaultSubscriber;

public class DemoDefaultSubscriber {

    public static void main(String... s) {
        Flowable.rangeLong(2, 12).subscribe(new DefaultSubscriber<Long>() {
            @Override
            public void onNext(Long aLong) {
                if (aLong == 4)
                    cancel();
                System.out.println(aLong);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }

            @Override
            public void onStart() {
                request(5);
            }
        });
    }
}
