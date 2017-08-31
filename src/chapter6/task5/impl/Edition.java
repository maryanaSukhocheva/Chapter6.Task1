package chapter6.task5.impl;

/**
 *
 * @author Sukhocheva Maryana
 */
public interface Edition {
   boolean takeHome(String startDate);
   boolean passEdition(String endDate);
   int countPages();
   
}
