import java.util.Random;

public class Scraper {
   private int hour, temp;

   public int scrapeWeather() {
      Random rand = new Random();

      if (hour >= 0 && hour <= 6) {
         do {
            temp = rand.nextInt(100);
         } while (temp < 40 || temp > 60);
      }
      
      else if (hour >= 7 && hour <= 12) {
         do {
            temp = rand.nextInt(100);
         } while (temp < 60 || temp > 75);
      }
      
      else if (hour >= 13 && hour <= 18) {
         do {
            temp = rand.nextInt(100);
         } while (temp < 70 || temp > 100);
      }
      
      else if (hour >= 19 && hour <= 23) {
         do {
            temp = rand.nextInt(100);
         } while (temp < 60 || temp > 70);
      }

      return temp;
   }

   public int scrapeTime() {
      hour = ++hour%24;
      return hour;
   }

   public boolean scrapeRain() {
      Random rand = new Random();
      int chance;

      chance = rand.nextInt(101);

      if (chance > 50 && temp <= 70)
         return true;
      else
         return false;
   }
}
