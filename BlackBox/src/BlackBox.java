import java.util.*;

public class BlackBox {

	public static void main(String[] args) throws InterruptedException {
		int actWeather, actTime;
		ArrayList<Activity> alist;
		ArrayList<Activity> flist;
		ArrayList<Activity> temp;
		BST<Activity> bst = new BST<Activity>();
		boolean actRain = false;
		Update u = new Update();

		while (true) {
			alist = new ArrayList<Activity>();
			flist = new ArrayList<Activity>();
			temp = new ArrayList<Activity>();
			bst.makeEmpty();

			// update dummy data
			u.update();
			actWeather = u.getActualWeather();
			actTime = u.getActualTime();
			actRain = u.getActualRain();

			System.out.println("actWeather " + actWeather);
			System.out.println("actTime " + actTime);
			System.out.println("actRain " + actRain);

			// create random activities:
			for (int t = 70; t <= 85; t++) {
				for (int hour = 8; hour <= 17; hour++) {
					if (!actRain)
						alist.add(new Activity(t, hour, "Hike Bishops"));
				}
			}

			for (int t = 40; t <= 85; t++) {
				for (int hour = 6; hour <= 14; hour++) {
					alist.add(new Activity(t, hour, "Blackhorse coffee"));
				}
			}

			for (int t = 65; t <= 85; t++) {
				for (int hour = 14; hour <= 20; hour++) {
					alist.add(new Activity(t, hour, "Nova Restaurant"));
				}
			}

			for (int t = 70; t <= 85; t++) {
				for (int hour = 9; hour <= 17; hour++) {
					alist.add(new Activity(t, hour, "Pirates Cove"));
				}
			}

			for (int t = 40; t <= 85; t++) {
				for (int hour = 6; hour <= 20; hour++) {
					alist.add(new Activity(t, hour, "Song of the day"));
				}
			}

			for (int t = 40; t <= 68; t++) {
				for (int hour = 6; hour <= 14; hour++) {
					alist.add(new Activity(t, hour, "Yerba Malte Beverage"));
				}
			}

			for (int t = 40; t <= 68; t++) {
				for (int hour = 11; hour <= 18; hour++) {
					if (actRain) {
						alist.add(new Activity(t, hour,
								"Indoor exercises for a Rainy Day"));
					}
				}
			}

			for (int t = 40; t < 75; t++) {
				for (int hour = 11; hour < 18; hour++) {
					alist.add(new Activity(t, hour, "Arts and Crafts"));
				}
			}

			for (int t = 80; t < 100; t++) {
				for (int hour = 13; hour < 18; hour++) {
					if (!actRain)
						alist.add(new Activity(t, hour,
								"Go to the freaking beach!"));
				}
			}

			Collections.sort(alist, new OrderWeight(new OrderWeather(new OrderTime())));
			
	      ListIterator<Activity> liter = alist.listIterator();

	      int count = 0;
	      while (liter.hasNext() && count != 3) {
	         Activity activity = ((Activity) liter.next());
	         if (activity.getTime() == actTime
	               && activity.getWeather() == actWeather) {
	            temp.add(activity);
	            count++;
	         }
	      }
	      flist = temp;

	      for (int i = 0; i < flist.size(); i++) {
	         System.out.println(flist.get(i));
	      }
	      System.out.println();
		}
	}
}
