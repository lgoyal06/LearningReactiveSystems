package rxjava;

import io.reactivex.Observable;

public class DemoObservable_empty {

    public static void main(String... s) {
        Observable<String> observable = Observable.empty();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Emittions completed"));
    }
}
