public class Restroom
{
   private boolean[] s;

   /**
      Constructs a restroom with a given number of stalls.
      @param ns the number of stalls
   */
   public Restroom(int ns)
   {
	s = new boolean [ns];
   }

   /*
      Adds an occupant in the middle of the longest sequence of
      unoccupied places. 
   */
   public void addOccupant()
   {
       int runLength = 0;
        int runStart = 0;
        int runMax = 0;
        int runMaxStart = 0;
        for (int i = 0; i< s.length +1; i++)
        {
            if(i == s. length)
            {    
                if (runLength > runMax)
                {
                runMax = runLength;
                runMaxStart = runStart;
                }    
        } else if (runLength == 0 && !s[i])
        {
           runStart = i;
           runLength++;
           
        } else
        {
           if (!s[i])
           {
                runLength++;
           }else
           {
                if (runLength > runMax)
                {
                    runMax = runLength;
                    runMaxStart = runStart;
                }
                runLength =0;
           }    
        }    
    }
    s [runMaxStart + runMax / 2] = true;
   }    
   /*
      Gets a string describing the current stall occupation
      @return a string with _ for an empty stall and X for an occupied one
   */
   public String getStalls()
   {
      String p = "";
        for (boolean r : s)
            p += r ? "X" : "_";
        return p;
   
   }
}
