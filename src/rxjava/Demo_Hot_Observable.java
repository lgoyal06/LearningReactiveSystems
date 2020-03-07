package rxjava;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Demo_Hot_Observable {

    public static void main(String... s) {
        ConnectableObservable observable = Observable.create(observer -> {
            observer.onNext("i am hot observable" + Math.random() * 100);
            observer.onComplete();
        }).publish();
        observable.subscribe(System.out::println);
        observable.subscribe(System.out::println);
        observable.connect();
    }
}
