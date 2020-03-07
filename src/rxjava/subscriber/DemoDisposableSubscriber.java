package rxjava.subscriber;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

public class DemoDisposableSubscriber {

    public static void main(String... s) {
        DisposableSubscriber<Long> disposableSubscriber = new DisposableSubscriber<Long>() {
            @Override
            public void onNext(Long aLong) {
                System.out.println(aLong);
                if (aLong == 7)
                    dispose();
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };
        Flowable.rangeLong(2, 12).subscribe(disposableSubscriber);
        disposableSubscriber.dispose();
    }
}
