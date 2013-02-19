import java.util.Comparator;

public class OrderTime implements Comparator<Activity> {

   private Comparator<Activity> c;

   public OrderTime() {
   }

   public OrderTime(Comparator<Activity> c) {
      this.c = c;
   }

   public int compare(Activity a, Activity b) {
      if (c == null)
         return b.getTime() - a.getTime();

      else {
         if (c.compare(a, b) == 0)
            return b.getTime() - a.getTime();

         else
            return c.compare(a, b);
      }
   }
}
