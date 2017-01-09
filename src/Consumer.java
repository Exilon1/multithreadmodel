import java.util.Random;

/**
 * Created by Nikotin on 09.01.2017.
 */
public class Consumer implements Runnable {


    private String name;
    private CollectionForThreads collectionForThreads;

    public Consumer(String name, CollectionForThreads collectionForThreads) {
        this.name = name;
        this.collectionForThreads = collectionForThreads;
        new Thread(this, name).start();
    }

    private Random random = new Random();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Consumer " + name + ": Поглощён " + collectionForThreads.get(name));

        }
    }

    public String getName() {
        return name;
    }
}
