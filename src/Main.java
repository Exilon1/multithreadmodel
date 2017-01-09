import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CollectionForThreads collectionForThreads = new CollectionForThreads();
        List<Runnable> list = new ArrayList<>(3);

        new Producer("Производитель", collectionForThreads);
        list.add(new Consumer("1", collectionForThreads));
        list.add(new Consumer("2", collectionForThreads));
        list.add(new Consumer("3", collectionForThreads));
        new Dispatcher(list, collectionForThreads);
    }
}
