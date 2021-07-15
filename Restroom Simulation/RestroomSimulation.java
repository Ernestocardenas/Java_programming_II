public class RestroomSimulation {

    public static void main(String[] args)
   {
      int STALLS = 10;
      Restroom wc = new Restroom(STALLS);

      for (int i = 1; i <= STALLS; i++)
      {
         wc.addOccupant();
         System.out.println(wc.getStalls());
      }
   }
   
}
