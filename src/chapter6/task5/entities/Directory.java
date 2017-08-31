package chapter6.task5.entities;

import chapter6.task5.exception.ParamsException;
import resources.Const;


/**
 *
 * @author Maryana_Sukhocheva
 * @version – 1
 */

//creation of the directory
public class Directory extends Book {
    private int partNumber;
    String publishingName;
    public Directory() {

    }
    public  Directory(String name, String author, int imprintDate,  int amount, boolean takedHome, int partNumber, String publishingName)  {
       super(name, author, imprintDate, amount,takedHome);
        try {
            setPartNumber(partNumber);
            setPublishingName(publishingName);
         } catch (ParamsException ex) {
            System.err.println(Const.rb.getString("DIRECTORY_ERROR"));
         }
       }

   

   
    private int getPartNumber() {
        return partNumber;
    }

    private void setPartNumber(int partNumber) throws ParamsException {
      if (partNumber>0) {
        this.partNumber = partNumber;
      } else {
         throw new ParamsException(Const.rb.getString("NUMBER_EXC"));
      }
    }

     private String getPublishingName() {
        return publishingName;
    }

   
    private void setPublishingName(String publishingName)  throws ParamsException {
        if (publishingName!=null && !publishingName.isEmpty()) {
            this.publishingName = publishingName;
        } else {
            throw new ParamsException(Const.rb.getString("PUBLISH_NAME_EXC"));
        }
    }
   


}