package chapter6.task5.entities;

import chapter6.task5.exception.ParamsException;
import chapter6.task5.impl.Edition;
import chapter6.task5.utils.Util;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import resources.Const;

/**
 *
 * @author Sukhocheva Maryana
 */
abstract class Book implements Edition {
   private int amountPages;
    private String nameBook;
    private String author;
    private int imprintDate;
    boolean takedHome;
    
    private Calendar currentCalendar = new GregorianCalendar();
    
    private Date startDateToHome;
    private Date endDateToHome;
    
    public Book(){
      
    }

    public Book(String name, String author, int imprintDate,  int amount, boolean takedHome) {
        try {
            setNameBook(name);
            setAuthor(author);
            setImprintDate(imprintDate);
            setTakedHome(takedHome);
            setAmountPages(countPages());
            this.startDateToHome = new Date();
        } catch (ParamsException ex) {
            System.out.println(Const.rb.getString("EDITION_ERROR"));
        }
      
   }

    public int getAmountPages() {
        return amountPages;
    }

    public void setAmountPages(int amountPages)  throws ParamsException {
         if (amountPages>0) {
            this.amountPages = amountPages;
        } else {
            throw new ParamsException(Const.rb.getString("AMOUNT_PAGES_EXC"));
        }
    }


    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) throws ParamsException {
        if (nameBook!=null && !nameBook.isEmpty()) {
            this.nameBook = nameBook;
        } else {
            throw new ParamsException(Const.rb.getString("NAME_EDITION_EXC"));
        }
    }

    public  String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    

    public int getImprintDate() {
        return imprintDate;
    }

 
    public void setImprintDate(int imprintDate) throws ParamsException {
        if ((imprintDate>0) && (imprintDate<=currentCalendar.get(Calendar.YEAR))) {
	    this.imprintDate = imprintDate;
	} else {
            throw new ParamsException(Const.rb.getString("IMPRINT_DATE_EXC"));
	}
      
    }
    public boolean isTakedHome() {
        return takedHome;
    }

   public void setTakedHome(boolean takedHome) {
        this.takedHome = takedHome;
    }

   public Date getStartDateToHome() {
        return startDateToHome;
    }
   public void setStartDateToHome(String startDateToHome) throws ParamsException {
         if (startDateToHome!=null && !startDateToHome.isEmpty()) {
             this.startDateToHome=Util.parseDate(startDateToHome);
         } else {
            throw new ParamsException(Const.rb.getString("DATE_START_EXC"));
        }
    }
   
   public Date getEndDateToHome() {
        return endDateToHome;
    }

   public void setEndDateToHome(String endDateToHome) throws ParamsException {
        if (endDateToHome!=null && !endDateToHome.isEmpty()) {
            this.endDateToHome =Util.parseDate(endDateToHome);
         } else {
            throw new ParamsException(Const.rb.getString("DATE_START_EXC"));
        }
    }
    @Override
     public int countPages(){
        Random rand = new Random();
        return rand.nextInt(990) + 10;
    }
    
    @Override
    public boolean takeHome(String startDate){
        boolean result=false;
        if (startDate!=null && !startDate.isEmpty() ){
            try {
                this.setTakedHome(true);
                this.setStartDateToHome(startDate);
                result = true;
            } catch (ParamsException ex) {
                System.out.println(Const.rb.getString("DATE_START_EXC"));
               
            }
            
        }
        return result;
    }
   
    @Override
    public boolean passEdition(String endDate) {
        boolean result = false;
        if (endDate != null && !endDate.isEmpty()) {
            try {
                this.setTakedHome(false);
                this.setEndDateToHome(endDate);
                result = true;
            } catch (ParamsException ex) {
                System.out.println(Const.rb.getString("DATE_START_EXC"));
            }
        }
        return result;
     }
 }