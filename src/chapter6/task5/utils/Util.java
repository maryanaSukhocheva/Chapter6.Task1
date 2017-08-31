package chapter6.task5.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import resources.Const;

/**
 *
 * @author Maryana_Sukhocheva
 */

public class Util {
     public static final String dateFormat = "dd.MM.yyyy";
     public static Date parseDate(String date)  {
         DateFormat formatter;
         Date parseDate = new Date() ;
         formatter = new SimpleDateFormat(dateFormat);
        try {
            parseDate = (Date)formatter.parse(date);
        } catch (ParseException ex) {
            System.out.println(Const.rb.getString("DATE_EXC"));
        }
        return parseDate;
     }
     
     public static String DateToStr(Date dateInput)  {
         String strDate = "";
         try {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            strDate = formatter.format(dateInput);
         } catch (Exception ex) {
             System.out.println(Const.rb.getString("DATE_EXC"));
         }
        return strDate;
     }

}
