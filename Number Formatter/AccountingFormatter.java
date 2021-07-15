//******************************************************************************
//Code
//******************************************************************************

public class AccountingFormatter implements NumberFormatter 
{
    public String format(int n)
    {
        if(n<0)
            return "("+String.valueOf(-1*n)+")";
        else
            return String.valueOf(n);
    }
}
