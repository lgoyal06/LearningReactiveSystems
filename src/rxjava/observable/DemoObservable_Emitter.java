package rxjava.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import java.util.Arrays;
import java.util.List;

public class DemoObservable_Emitter {

    public static void main(String... s) {
        Observable<String> month_observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                try {
                    String[] monthArray = {"Jan", "Feb", "March", "April", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
                    List<String> months = Arrays.asList(monthArray);
                    for (String month : months) {
                        observableEmitter.onNext(month);
                        Thread.sleep(1000);
                    }
                    observableEmitter.onComplete();
                } catch (Exception e) {
                    observableEmitter.onError(e);
                }
            }
        });
        month_observable.subscribe(System.out::println);
    }
}
