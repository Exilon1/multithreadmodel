import java.util.ArrayList;

import java.util.List;
import java.util.Random;

/**
 * Created by Nikotin on 09.01.2017.
 */
public class Producer implements Runnable {

    private String name;
    private CollectionForThreads collectionForThreads;

    public Producer(String name, CollectionForThreads collectionForThreads) {
        this.name = name;
        this.collectionForThreads = collectionForThreads;
        new Thread(this, name).start();
    }

    private Random random = new Random();

    @Override
    public void run() {
        while (true) {
            List<Product> list = new ArrayList<>();
            for(int i=0; i<=random.nextInt(5)+1; i++)
                list.add(new Product(IdGenerator.nextId()));
            collectionForThreads.put(list);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }
}
