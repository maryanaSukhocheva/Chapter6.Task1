package chapter6.task5.main;
import chapter6.task5.entities.*;
import chapter6.task5.utils.Util;
import java.util.ResourceBundle;
import resources.Const;
/**
 *
 * @author Sukhocheva Maryana
 */
public class Main {
   public static void main(String[] args) {
            
            Const constant = new Const();
            System.out.println(Const.rb.getString("BEGIN_PROGRAM"));
            
            Directory directory = new Directory("Большая Советская Энциклопедия", "Коллектив авторов", 1926, 100000, false, 66, "Советская энциклопедия");
            System.out.println(Const.rb.getString("CREATE_BOOK"));
            directory.takeHome("21.08.2017");
            System.out.println(Const.rb.getString("BOOK_TAKED") + " " + Util.DateToStr(directory.getStartDateToHome()));
            directory.passEdition("01.09.2017");
            System.out.println(Const.rb.getString("BOOK_RETURN") + " " + Util.DateToStr(directory.getEndDateToHome()));
    } 
}
