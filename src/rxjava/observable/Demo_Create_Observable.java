package rxjava.observable;


import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo_Create_Observable {

    public static void main(String... s) {
        Integer[] nums = new Integer[]{3, 3, 3, 4, 5, 6, 5};
        List<Integer> numList = Arrays.asList(nums);
        // Consumer<List<Integer>> consumer = item->System.p
        Observable.just(numList).subscribe(item -> System.out.println(item));
    }
}
