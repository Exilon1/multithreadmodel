import entity.*;
import storage.Storage;
import utilities.*;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

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
        /*
         * Домашнее задание с локалями:
         *
         */
        request = scanner.nextLine();
        if("en".equals(request)) {
            bundle = ResourceBundle.getBundle("resources.prop", new Locale("en", "UK"));
            System.out.println(bundle.getString("prop.key"));
        } else if("ru".equals(request)) {
            bundle = ResourceBundle.getBundle("resources.prop", new Locale("ru", "RU"));
            System.out.println(bundle.getString("prop.key"));
        }

        System.out.println("Формат ввода:");
        System.out.println("г. Тольятти, ул. Мира, д. 106, п. 2/г. Тольятти, ул. Мира, д. 106, п. 2/yes/yes/1");


        while (true) {

            request = scanner.nextLine();

            FreeTheCar.freeTheCar(carList);
            Order order = null;
            try {
                order = OrderReader.orderRead(request);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            Car car = CarSearch.searchFreeCar(carList, order);
            if (car == null) {
                System.out.println("All cars are reserved. Please, try again later.");
                continue;
            }
            System.out.println("Your car:");
            System.out.println(car);
        }
    }
}
