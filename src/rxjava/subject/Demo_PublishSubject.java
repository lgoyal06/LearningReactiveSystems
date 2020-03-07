package rxjava.subject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class Demo_PublishSubject {

    public static void main(String... s) {
        PublishSubject<Long> publishSubject = PublishSubject.create();
        publishSubject.onNext(122l);
        Observer<Long> observer = new Observer<Long>() {
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
        };
        publishSubject.subscribe(observer);
        publishSubject.onNext(12l);
        publishSubject.onNext(22l);
    }
}
