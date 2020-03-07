package rxjava;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class DemoDefer {

    public static void main(String... s) {
        String[] monthArray = {"Jan", "Feb", "March", "April", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> monthList = Arrays.asList(monthArray);
        Observable.defer(() -> Observable.just(monthList)).create(subscribe -> {
            try {
                for (String data : monthList) {
                    System.out.println("emitting data");
                    subscribe.onNext(data);
                }
                subscribe.onComplete();
            } catch (Exception e) {
                subscribe.onError(e);
            }
        }).subscribe(item -> System.out.println(item), error -> System.out.println(error), () -> System.out.println("Emission completed"));
    }
}
