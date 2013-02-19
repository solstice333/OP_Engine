import java.util.Comparator;

public class OrderWeather implements Comparator<Activity> {

   private Comparator<Activity> c;

   public OrderWeather() {
   }

   public OrderWeather(Comparator<Activity> c) {
      this.c = c;
   }

   public int compare(Activity a, Activity b) {
      if (c == null)
         return b.getWeather() - a.getWeather();

      else {
         if (c.compare(a, b) == 0)
            return b.getWeather() - a.getWeather();

         else
            return c.compare(a, b);
      }
   }
}
