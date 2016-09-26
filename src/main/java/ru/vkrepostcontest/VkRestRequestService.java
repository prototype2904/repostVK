package ru.vkrepostcontest;


import org.springframework.stereotype.Service;
import ru.vkrepostcontest.util.DateUtil;

import java.util.Date;

/**
 * @author Stetskevich Roman on 07.09.2016.
 * @since 0.1
 */
@Service
public class VkRestRequestService {

	/**
	 * максимум результатов из ВК
     */
    public static int OFFSET = 1000;

    /**
     * запросов секунду
     */
    private static final int REQUESTS_PER_SEC = 3;

    /**
     * период одного запроса в миллисекундах
     */
    private static int PERIOD = OFFSET / REQUESTS_PER_SEC;

    /**
     * следующий запуск
     */
    private static Date nextRequest = new Date();


    /**
     * выполняять запрос не чаще чем в PERIOD
     * @param requestAction
     */
    public synchronized void doRequest(RequestAction requestAction){
        long differenceInMillis = DateUtil.getDifferenceInMillis(nextRequest);
        if(differenceInMillis < 0){
            try {
                Thread.sleep(-differenceInMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestAction.doAction();
        nextRequest = DateUtil.addMilliSeconds(PERIOD);
    }
}
