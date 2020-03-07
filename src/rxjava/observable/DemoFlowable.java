package rxjava.observable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class DemoFlowable {

    public static void main(String... s) {
        Flowable<String> month_maybe = Flowable.create(emitter -> {
            try {
                String[] monthArray = {"Jan", "Feb", "March", "April", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
                for (String month : monthArray) {
                    emitter.onNext(month);
                }
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        }, BackpressureStrategy.MISSING);
        month_maybe.subscribe(System.out::println);
    }

}
