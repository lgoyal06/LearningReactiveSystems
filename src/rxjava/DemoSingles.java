package rxjava;

import io.reactivex.Single;

import java.util.Arrays;
import java.util.List;

public class DemoSingles {

    public static void main(String... s) {
        Single<String> month_maybe = Single.create(emitter -> {
            try {
                String[] monthArray = {"Jan", "Feb", "March", "April", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
                List<String> months = Arrays.asList(monthArray);
                if (months != null && !months.isEmpty()) {
                    emitter.onSuccess(months.get(0));
                }
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
        month_maybe.subscribe(System.out::println);
    }
}
