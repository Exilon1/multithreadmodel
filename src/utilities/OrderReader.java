package utilities;

import entity.Order;
import exceptions.NotCompleteRequestException;
import exceptions.NotValidCarClassException;
import exceptions.UndetectableBabySeatParamException;
import exceptions.UndetectableSmokeCarParamException;

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

    public static Order orderRead(String request) throws Exception {
        String[] params = request.split("\\|");
        if (params.length<5)
            throw new NotCompleteRequestException();
        if (!"yes".equals(params[2].toLowerCase()) && !"no".equals(params[2].toLowerCase()))
            throw new UndetectableBabySeatParamException();
        if (!"yes".equals(params[3].toLowerCase()) && !"no".equals(params[3].toLowerCase()))
            throw new UndetectableSmokeCarParamException();
        if (!Integer.toString(0).equals(params[4]) && !Integer.toString(1).equals(params[4]))
            throw new NotValidCarClassException();

        String startPoint = params[0];
        String endPoint = params[1];
        boolean isNeedBabySeat = "yes".equals(params[2].toLowerCase());
        boolean isNeedSmokeCar = "yes".equals(params[3].toLowerCase());
        int needCarClass = Integer.valueOf(params[4]);

        return new Order(startPoint, endPoint, isNeedBabySeat, isNeedSmokeCar, needCarClass);
    }


}
