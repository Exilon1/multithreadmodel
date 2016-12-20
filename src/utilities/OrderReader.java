package utilities;

import entity.Order;
import exceptions.*;
import utilities.constants.TypeOfClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utilities.constants.Constants.*;

/**
 * Created by Alexey on 30.10.2016.
 */
public class OrderReader {

    private OrderReader() {
    }

    private static class SingletonHelper {
        private static final OrderReader SINGLETON = new OrderReader();
    }

    public static OrderReader getInstance() {
        return SingletonHelper.SINGLETON;
    }

    private static final String YES_PARAM = "yes";
    private static final String NO_PARAM = "no";
    private static final String ADRESS_REGEX = "ул.\\s[А-Я][а-я]+,\\sд.\\s[1-9][0-9]*(,\\sп.\\s[1-9])?";
    // г. Тольятти, ул. Мира, д. 106, п. 2

    public static Order orderRead(String request) throws Exception {
        String[] params = request.split("/");
        if (params.length<5)
            throw new NotCompleteRequestException();
        if(!isValidAdress(params[0]) && !isValidAdress(params[1]))
            throw new NotValidAdressException();
        if (!YES_PARAM.equals(params[2].toLowerCase()) && !NO_PARAM.equals(params[2].toLowerCase()))
            throw new UndetectableBabySeatParamException();
        if (!YES_PARAM.equals(params[3].toLowerCase()) && !NO_PARAM.equals(params[3].toLowerCase()))
            throw new UndetectableSmokeCarParamException();
        if (!Integer.toString(TypeOfClass.ECONOMIC.getCarClass()).equals(params[4]) && !Integer.toString(TypeOfClass.BUSYNESS.getCarClass()).equals(params[4]))
            throw new NotValidCarClassException();

        String startPoint = params[0];
        String endPoint = params[1];
        boolean isNeedBabySeat = YES_PARAM.equals(params[2].toLowerCase());
        boolean isNeedSmokeCar = YES_PARAM.equals(params[3].toLowerCase());
        int needCarClass = Integer.valueOf(params[4]);

        return new Order(startPoint, endPoint, isNeedBabySeat, isNeedSmokeCar, needCarClass);
    }

    private static Pattern p = Pattern.compile(ADRESS_REGEX);

    private static boolean isValidAdress(String adress) {
        Matcher m = p.matcher(adress);
        return m.matches();
    }

}
