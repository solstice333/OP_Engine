import java.io.*;
import java.util.*;

public class Activity implements Comparable<Activity> {

   private int weather, time, weight;
   private String name;

   public Activity(int w, int t, String n) {
      weather = w;
      time = t;
      name = n;
      
      weight = new Random().nextInt(100);
   }

   public int getWeather() {
      return weather;
   }

   public int getTime() {
      return time;
   }
   
   public int getWeight() {
      return weight;
   }

   public String toString() {
      return "name: " + name + ", " + "time: " + time + ", " + "weather: "
            + weather + ", " + "weight: " + weight;
   }

   public int compareTo(Activity a) {
      return this.weather - a.weather;
   }
   
   public boolean equalsString(Activity other) {
      return this.name.equals(other.name);
   }
}
