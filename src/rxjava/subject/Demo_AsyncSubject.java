package rxjava.subject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.AsyncSubject;

public class Demo_AsyncSubject {

    public static void main(String... s) {
        AsyncSubject<Long> asyncSubject = AsyncSubject.create();
        asyncSubject.onNext(23l);
        asyncSubject.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("On subscribe");
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println(aLong);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
        asyncSubject.onNext(10l);
        asyncSubject.onNext(4l);
        asyncSubject.onNext(1l);
        asyncSubject.onComplete();
    }
}
