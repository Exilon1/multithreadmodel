package treades;

import entity.Order;
import storage.Storage;
import utilities.OrderReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikotin on 26.12.2016.
 */
public class OrderEmulator implements Runnable {


    List<Order> list = new ArrayList<>(10);

    public OrderEmulator() {
        try {
            list.add(OrderReader.orderRead("ул. Мира, д. 106, п. 2/ул. Мира, д. 106, п. 2/yes/yes/1"));
            list.add(OrderReader.orderRead("ул. Мира, д. 106, п. 2/ул. Мира, д. 106, п. 2/yes/yes/0"));
            list.add(OrderReader.orderRead("ул. Мира, д. 106, п. 2/ул. Мира, д. 106, п. 2/yes/no/1"));
            list.add(OrderReader.orderRead("ул. Мира, д. 106, п. 2/ул. Мира, д. 106, п. 2/no/yes/0"));
            list.add(OrderReader.orderRead("ул. Мира, д. 106, п. 2/ул. Мира, д. 106, п. 2/no/yes/1"));
            list.add(OrderReader.orderRead("ул. Мира, д. 106, п. 2/ул. Мира, д. 106, п. 2/yes/no/0"));
            list.add(OrderReader.orderRead("ул. Мира, д. 106, п. 2/ул. Мира, д. 106, п. 2/no/no/1"));
            list.add(OrderReader.orderRead("ул. Мира, д. 106, п. 2/ул. Мира, д. 106, п. 2/no/no/0"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for(Order order: list)
            new Thread(new WaitingCarThread(order)).start();
    }
}
