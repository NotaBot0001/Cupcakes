import java.time.LocalTime;
import java.util.Random;

/**
 * Filename: CupcakeEmporium.java Written by: Cake Bytes Written on: 10/5/2021
 * Application for Cupcake Emporium
 */

public class CupcakeEmporium {


   public static void main(String args[]) {
      LocalTime startTime = LocalTime.now();
      int min = startTime.getMinute();
      int second = startTime.getSecond();

      // Create a CupcakeMenu Object
      CupcakeMenu menu = new CupcakeMenu();

      LocalTime endTime = randDuration(startTime);

      while (true) {
         // LocalTime t = LocalTime.now();
         if(LocalTime.now().isAfter(endTime)){
            System.out.println("Bankrupt! Try Again!!!");
            break;
         }
         // Display the menu
         menu.displayMenu();
         // Get the choice from the user
         menu.getChoice();
      }         
   }

   // intialize random duration
   private static LocalTime randDuration(LocalTime t){
      int MIN_DURATION = 3;
      Random rand = new Random();

      // Disaster will happen between 0 and N seconds
      int N = MIN_DURATION * 60;
      int randDuration = rand.nextInt(N);
      long min = 0;
      long sec = 0;

      // New Time object (endTime)
      LocalTime nt; 

      System.out.println("Min(t): " + t.getMinute());
      System.out.println("Sec(t): " + t.getSecond());

      System.out.println("Duration in seconds " + randDuration);

      min = (randDuration / 60) % 60; // Get minutes from time
      sec = randDuration % 60;        // Get seconds from time

      // New Time Object
      nt = t;
      nt = nt.plusMinutes(min);
      nt = nt.plusSeconds(sec);

      System.out.println("Min(nt): " + nt.getMinute());
      System.out.println("Sec(nt): " + nt.getSecond());

      return nt;
   }
}

