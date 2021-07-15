//******************************************************************************
//import
//******************************************************************************
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.TreeMap;

//******************************************************************************
//Code
//******************************************************************************
/**
   Class for simulating trading a single stock at varying prices.
*/
public class StockSimulator
{
   private Map<String, Queue<Block>> blocks;

   /**
      Constructor.
   */
   public StockSimulator()
   {
      blocks = new TreeMap<>();
   }

   /**
      Handle a user buying a given quantity of stock at a given price.

      @param quantity how many to buy.
      @param price the price to buy.
   */
   public void buy(String symbol, int quantity, int price)
   {
      Queue<Block> quant = blocks.get(symbol.toUpperCase());
      
       //if there are no shares it will create a new blok and put a value
       if(quant == null)
       { 
        
        quant = new LinkedList<Block>();
        blocks.put(symbol.toUpperCase(), quant);
       
       }
     
     quant.add(new Block(quantity, price));
  
   }

   /**
      Handle a user selling a given quantity of stock at a given price.
      @param symbol the stock to sell
      @param quantity how many to sell.
      @param price the price to sell.
   */
   public void sell(String symbol, int quantity, int price)
   {
       Queue<Block> quant = blocks.get(symbol.toUpperCase());
       int gains = 0;
       
       if(quant == null)
       { 

        System.out.println("No shares of " + symbol);
  
       } else
         {
          
          while(quantity > 0)
          {
            Block newBlock = quant.peek();

            if(newBlock.getQuantity() <= quantity)
            {
             
             gains += newBlock.getQuantity() * (price - newBlock.getPrice());
             quantity -= newBlock.getQuantity();
             quant.remove();
            
            } else
              {
        
               gains += quantity * (price - newBlock.getPrice());
               newBlock.sell(quantity);
               quantity = 0;      
              
              } 
          }
         }
  
      if(gains >= 0)
      {

       System.out.println("Gains: " + gains);

      }else 
       {

       System.out.println("Loss: " + gains);

       }
   }
}
