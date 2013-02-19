import java.util.*;

public class test {

   public static void main(String[] args) {
      ArrayList<Activity> a1 = new ArrayList<Activity>();
      ArrayList<Activity> temp = new ArrayList<Activity>();
      int actTime = 15;
      int actWeather = 75;

      for (int t = 40; t <= 85; t++) {
         for (int hour = 6; hour <= 14; hour++) {
            a1.add(new Activity(t, hour, "Blackhorse coffee"));
         }
      }

      for (int t = 40; t <= 85; t++) {
         for (int hour = 6; hour <= 20; hour++) {
            a1.add(new Activity(t, hour, "Song of the day"));
         }
      }

      Collections.sort(a1, new OrderWeight(new OrderWeather(new OrderTime())));

      ListIterator<Activity> liter = a1.listIterator();

      int count = 0;
      while (liter.hasNext() || count != 3) {
         Activity activity = ((Activity) liter.next());
         if (activity.getTime() == actTime
               && activity.getWeather() == actWeather) {
            temp.add(activity);
            count++;
         }
      }
      
      for (int i = 0; i < temp.size(); i++) {
         System.out.println(temp.get(i));
      }

      /*
      for (int i = 0; i < a1.size(); i++) {
         System.out.println(a1.get(i));
      }
      */

   }
}
