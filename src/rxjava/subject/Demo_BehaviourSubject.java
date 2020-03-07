package rxjava.subject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;

public class Demo_BehaviourSubject {

    public static void main(String... s) {
        BehaviorSubject<Long> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.onNext(10l);
        behaviorSubject.onNext(20l);
        behaviorSubject.onNext(15l);
        behaviorSubject.subscribe(new Observer<Long>() {
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
        behaviorSubject.onNext(110l);
        behaviorSubject.onNext(210l);
        behaviorSubject.onNext(125l);
    }
}
