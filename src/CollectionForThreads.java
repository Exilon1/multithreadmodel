import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 08.01.2017.
 */
public class CollectionForThreads {

    private boolean valuePut = true;
    private boolean valueGet = true;
    private boolean noProducts = false;

    private List<Product> list = new ArrayList<Product>();

    public synchronized void put(List<Product> product) {
        while (!valuePut) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valueGet = false;
        list.addAll(product);
        System.out.println("Создан " + product);
        valueGet = true;
        notify();
    }


    public synchronized Product get(String cunsomerName){
        if (list.isEmpty()) {
            System.out.println("Consumer: " + cunsomerName + " Продукты кончились. Сплю.");
        }
        while (!valueGet || list.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        valuePut = false;
        Product product = null;
        product = list.get(0);
        list.remove(0);
        valuePut = true;
        return product;
    }

    public boolean productListIsEmpty() {
        return list.isEmpty();
    }

    public synchronized void changeState(boolean flag) {
        noProducts = flag;
    }

}
