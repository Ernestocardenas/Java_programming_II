//******************************************************************************
//import
//******************************************************************************
import java.util.Scanner;

/**
* Converts a numeric pin to an equivalent word using the digit to 
* letter mapping on a standard telephone keypad.
*/

//******************************************************************************
//Code
//******************************************************************************
public class PinWordEnumerator 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a pin number-> ");
        String num = scan.nextLine();
        System.out.println();
        System.out.printf("The keypad encodings for %s are:%n",num);        
        enumerateWords(num);
    }
    
    /**
    * Method to return character array for all possible keypad   
    */
    static char[] getKeysForButton(int n) {
        switch (n) {
            case 0:
                    return new char[] { ' ' }; //returning only space
            case 1:
                    return new char[] { '.' }; //returning only dot
            case 2:       
                    return new char[] { 'A', 'B', 'C' };
            case 3:
                    return new char[] { 'D', 'E', 'F' };
            case 4:
                    return new char[] { 'G', 'H', 'I' };
            case 5:
                    return new char[] { 'J', 'K', 'L' };
            case 6:
                    return new char[] { 'M', 'N', 'O' };
            case 7:
                    return new char[] { 'P', 'Q', 'R', 'S' };
            case 8:
                    return new char[] { 'T', 'U', 'V' };
            case 9:
                    return new char[] { 'W', 'X', 'Y', 'Z' };
        }
        return null;
    }
    public static void enumerateWords(String n)
    {
        /**
         * calling the recursive method to perform the enumeration
         */
            if (n != null)
                    enumerateWords(n, "");
    }
    
    /**
     * 
     * The main method which performs the recursion
     *
     * @param num
     * - current number
     * @param text
     * - text containing converted spellings
     */
    
    static void enumerateWords(String num, String text) {
        if (num.length() == 0) {
            // base case, displaying the text
            System.out.println(text);
        } 
        else {
            // finding the digit at 0th position
            int digit = num.charAt(0) - '0';
            
            // finding possible phone keys for this digit
            char letters[] = getKeysForButton(digit);
            if (letters != null) {
                // looping through all possible keys
                for (int i = 0; i < letters.length; i++) {
                    /**
                     * 
                     * Adding the letter to the text and calling the
                     * recursive method 
                     */
                    enumerateWords(num.substring(1), text + letters[i]);
                }
            }   
        }
    }
}
