//******************************************************************************
//Code
//******************************************************************************

public class BaseFormatter implements NumberFormatter 
{
int base;
public BaseFormatter(int b)
    {
        base = b;
        //if values out of range 2-36 inclusive are given, set default to 2
        if(base < 2 || base > 36)
        base = 2;
    }

    public String format(int n)
    {
        return Integer.toString(n, base);
    }

    int getBase()
    {
        return base;
    }
}
