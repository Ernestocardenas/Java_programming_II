//*******************************************************************************
//Import
//*******************************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//*******************************************************************************
//Code
//*******************************************************************************

public class BalanceTransactions 
{
    /**
    *
    * @param args Command line arguments
    * @throws FileNotFoundException If path doesn't exist
    */
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        try 
        {
            doEverything();
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println(e.getMessage());
        }
    }
 
    /**
    *  
    * @throws FileNotFoundException If path doesn't exist
    */
      
    private static void doEverything() throws FileNotFoundException 
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> invoice = new ArrayList<Integer>();
        ArrayList<Double> cash = new ArrayList<Double>();
        ArrayList<String> PR = new ArrayList<String>();
        
        // User file name
        System.out.println("Please enter the file name for input: ");
        Scanner readFile = new Scanner(new File(in.next()));
        // Starting Cash 
        System.out.println("Enter the amount of cash you started with: ");
        double startingCash = in.nextDouble();
        // Ending amount 
        System.out.println("Enter the amount of cash you ended with: ");
        double endingCash = in.nextDouble();
 
        
 
        //Filling ArrayLists
        while (readFile.hasNext()) 
        {
            invoice.add(readFile.nextInt());
            cash.add(readFile.nextDouble());
            PR.add(readFile.next());
        }
 
        //Determining whether to add or subtract from startingCash
        for (int i = 0; i < invoice.size(); i++) 
        {
            if (PR.get(i).equals("P")) 
            {
            startingCash -= cash.get(i);
            }
            if (PR.get(i).equals("R")) 
            {
            startingCash += cash.get(i);
            }
        }
 
        /** 
         * 
         * Determines whether the right amount is in the register prints 
         * the results
         */
            // Comparing ending balance
            if(startingCash == endingCash)
        {
            System.out.println("End of the day total is properly balanced.");
        }
        else
        {
            System.out.println("End of the day total is not balanced.");
            System.out.println("Computed ending total: " + startingCash);
        
        }
            // Closing file    
            in.close();
            readFile.close();
    }
}
