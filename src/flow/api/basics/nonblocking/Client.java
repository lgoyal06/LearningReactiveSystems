package flow.api.basics.nonblocking;

public class Client {

    public static void main(String ...s){
        NumberPublisher numberPublisher = new NumberPublisher();
        NumberSubscriber numberSubscriber = new NumberSubscriber();
        numberPublisher.subscribe(numberSubscriber);
    }
}
