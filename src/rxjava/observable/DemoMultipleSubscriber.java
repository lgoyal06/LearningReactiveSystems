package rxjava.observable;


import io.reactivex.Observable;

public class DemoMultipleSubscriber {

    public static void main(String... s) {
        String[] monthArray = {"Jan", "Feb", "March", "April", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Observable<Object> observable = Observable.create(subscriber -> {
            try {
                System.out.println("creating");
                for (String month : monthArray) {
                    subscriber.onNext(month);
                }
                subscriber.onComplete();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        }).cache();

        observable.subscribe(System.out::println);
        observable.subscribe(System.out::println);
    }
}
