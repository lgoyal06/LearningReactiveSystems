package rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoObservable {


    public static void neverObservable() {
        Observable<String> observable = Observable.never();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Emissions completed"));
    }

    public static void errorObservable() {
        Observable<String> observable = Observable.error(new Exception("We got an exception"));
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Emissions completed"));
    }

    public static void fromArrayToObservable() {
        String[] monthArray = {"Jan", "Feb", "March", "April", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Observable.fromArray(monthArray).subscribe(System.out::println, System.out::println, () -> System.out.println("Emissions completed"));
    }

    public static void fromListToObservable() {
        String[] monthArray = {"Jan", "Feb", "March", "April", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> list = Arrays.asList(monthArray);
        Observable.fromIterable(list).subscribe(System.out::println, System.out::println, () -> System.out.println("Emissions completed"));
    }

    public static void intervalInObservable() {
        Observable<Long> myObservable = Observable.interval(2, TimeUnit.SECONDS);
        Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Long aLong) {
                System.out.println(aLong);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Emission completed");
            }
        };
        myObservable.subscribe(observer);
    }

    public static void rangeObservable(int start, int end) {
        Observable<Integer> observable = Observable.range(start, end);
        observable.subscribe(System.out::println);
    }

    public static void main(String... s) throws InterruptedException {
        //neverObservable();
        //errorObservable();
        // fromArrayToObservable();
        //fromListToObservable();
        //intervalInObservable();
        //Thread.sleep(10000);
        rangeObservable(10, 20);
    }

}
