public class Update {
   private int actualTime, actualWeather;
   private boolean actualRain;
   private Scraper s = new Scraper();

   public void update() throws InterruptedException {
      Thread.sleep(1000);

      actualTime = s.scrapeTime();
      actualWeather = s.scrapeWeather();
      actualRain = s.scrapeRain();
   }

   public int getActualTime() {
      return actualTime;
   }

   public int getActualWeather() {
      return actualWeather;
   }
   
   public boolean getActualRain() {
      return actualRain;
   }
}