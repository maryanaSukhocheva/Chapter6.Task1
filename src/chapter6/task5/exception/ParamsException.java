package chapter6.task5.exception;

import java.util.logging.Logger;

/**
 *
 * @author Maryana_Sukhocheva
 * @version – 1
 * Исключение, возникающее при некорректно введенных параметрах
 */

public class ParamsException extends Exception{
    public ParamsException()    {
    }

    public ParamsException(String msg) {
        System.err.println(msg);
    }


 }
