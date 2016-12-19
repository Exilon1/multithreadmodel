package utilities;

import entity.Car;
import entity.Driver;
import entity.User;
import utilities.constants.CarMark;
import utilities.constants.TypeOfClass;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static utilities.constants.Constants.*;

/**
 * Created by Alexey on 13.11.2016.
 */
public class EntitiesGenerator {

    private static int i=0;
    private static final String ALL_CHARS = "abcdefghijklmnopqrstuvwxyz";

    private static Random random = new Random();
    public static Car nextCar() {
        boolean isSmokeCar = random.nextBoolean();
        boolean isHaveBabySeat = random.nextBoolean();
        String carNumber = ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())) +
                Integer.toString((random.nextInt(9)+1)*100 + random.nextInt(100)); //генерирует номер вида a000

        if ( i>3 )
            i = 0;
        CarMark carMark = CarMark.values()[i];
        i++;

        int carClass;
        if (i%2==0)
            carClass = TypeOfClass.ECONOMIC.getCarClass();
        else carClass = TypeOfClass.BUSYNESS.getCarClass();


        Car car = new Car(carMark.getMark(), carNumber, carClass);
        car.setSmokeCar(isSmokeCar);
        car.setHaveBabySeat(isHaveBabySeat);
        car.setCarStatus(TYPE_OF_STATUS_FREE);
        return car;
    }

    private static int j=1;
    public static Driver nextDriver() {
        Driver driver = new Driver("Driver name " + j);
        j++;
        String phoneNumber = Integer.toString(((random.nextInt(9)+1)*100 + random.nextInt(100))*1000);
        driver.setPhoneNumber(phoneNumber);
        return driver;
    }

    private static int k=0;
    public static User nextUser() {
        String phoneNumber = Integer.toString(((random.nextInt(9)+1)*100 + random.nextInt(100))*1000);
        User user = new User(k, phoneNumber, 0);
        k++;
        return user;
    }

}
