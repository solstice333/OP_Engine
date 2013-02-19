import java.util.Comparator;

public class OrderWeight implements Comparator<Activity> {

   private Comparator<Activity> c;

   public OrderWeight() {
   }

   public OrderWeight(Comparator<Activity> c) {
      this.c = c;
   }

   public int compare(Activity a, Activity b) {
      if (c == null)
         return b.getWeather() - a.getWeather();

      else {
         if (c.compare(a, b) == 0)
            return b.getWeight() - a.getWeight();

         else
            return c.compare(a, b);
      }
   }
}
