import java.util.List;

/**
 * Created by Nikotin on 09.01.2017.
 */
public class Dispatcher implements Runnable {

    private String name;
    private CollectionForThreads collectionForThreads;
    private List<Runnable> consumerList;

    public Dispatcher(List<Runnable> consumerList, CollectionForThreads collectionForThreads) {
        name = "Диспетчер";
        this.consumerList = consumerList;
        this.collectionForThreads = collectionForThreads;
        new Thread(this, name).start();
    }


    @Override
    public void run() {
        while (true) {
            if(!collectionForThreads.productListIsEmpty())
                collectionForThreads.changeState(false);
        }
    }

    public String getName() {
        return name;
    }
}
