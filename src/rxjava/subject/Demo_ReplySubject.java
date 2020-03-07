package rxjava.subject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.ReplaySubject;

public class Demo_ReplySubject {

    public static void main(String... s) {
        ReplaySubject<Long> replaySubject = ReplaySubject.create();
        replaySubject.onNext(122l);
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
        replaySubject.subscribe(observer);
        replaySubject.onNext(12l);
        replaySubject.onNext(22l);
    }
}
