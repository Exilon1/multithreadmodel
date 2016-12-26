import entity.*;
import storage.MyLinkedList;
import treades.WaitingCarThread;
import utilities.*;

import java.util.*;

/**
 * Created by дима on 30.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Car> carList = Initialization.initCarList();
        Initialization.initDriverList();
        Initialization.initDriversByCars();
        Initialization.initUserList();

        Scanner scanner = new Scanner(System.in);
        String request = null;
        ResourceBundle bundle;

        System.out.println("Введите локаль ru или en");

 /*         request = scanner.nextLine();
        if("en".equals(request)) {
            bundle = ResourceBundle.getBundle("resources.prop", new Locale("en", "UK"));
            System.out.println(bundle.getString("prop.key"));
        } else if("ru".equals(request)) {
            bundle = ResourceBundle.getBundle("resources.prop", new Locale("ru", "RU"));
            System.out.println(bundle.getString("prop.key"));
        }
*/
        System.out.println("Формат ввода:");
        System.out.println("ул. Мира, д. 106, п. 2/ул. Мира, д. 106, п. 2/yes/yes/1");


        while (true) {

            request = scanner.nextLine();

            FreeTheCar.freeTheCar(carList);
            Car car = null;
            Order order = null;
            try {
                order = OrderReader.orderRead(request);
                new Thread(new WaitingCarThread(order)).start();
 //               car = CarSearch.searchFreeCar(carList, order);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
/*
            if (car == null) {
                System.out.println("All cars are reserved. Please, try again later.");
                continue;
            }
            System.out.println("Your car:");
            System.out.println(car);
*/
        }
    }
}
