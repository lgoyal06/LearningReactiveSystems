package rxjava.subscriber;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;

import java.util.Arrays;
import java.util.List;

public class DemoCompositeDisposable {

    public static void main(String... s) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(Flowable.rangeLong(10, 5).subscribe(System.out::println));
        compositeDisposable.add(Flowable.rangeLong(10, 5).subscribe(it -> System.out.println("two::>" + it)));
        compositeDisposable.add(Observable.create(new ObservableOnSubscribe<String>() {
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
        }).subscribe(System.out::println));
        compositeDisposable.dispose();
    }
}
