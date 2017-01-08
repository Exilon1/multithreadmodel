import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 08.01.2017.
 */
public class CollectionToFill {

    private boolean valueSet = false;
    private List<Boolean> flagList = new ArrayList<Boolean>();

    private List<Product> list = new ArrayList<Product>();

    public synchronized void put(Product product) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valueSet = false;

        for(Product p: list)
            if(p==null)
                list.remove(p);
        list.add(product);
        fillFlagList(list.size());
        System.out.println("Создан " + product);

        valueSet = true;
        notifyAll();
    }


    public Product get(Thread thread) {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Boolean b: flagList) {
            if (!b) {

            }

        }

        valueSet = true;



        valueSet = false;
        notify();
        return null;
    }

    private void fillFlagList(int size) {
        flagList.clear();
        for(int i=0; i<size; i++)
            flagList.add(false);
    }
}
