package rxjava;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Demo_Cold_Observable {

    public static void main(String ...s){
        Observable observable = Observable.create(observer -> {
            observer.onNext("i am hot observable" + Math.random() * 100);
            observer.onComplete();
        });
        observable.subscribe(System.out::println);
        observable.subscribe(System.out::println);
        //observable.connect();
    }
}
