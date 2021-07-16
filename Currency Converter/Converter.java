//******************************************************************************
//Code
//******************************************************************************

public class Converter {
/**
    * 
    * constants for conversion rates
    */
    private static final double EUR_to_USD = 1.42;
    private static final double GBP_to_USD = 1.64;
    private static final double GBP_to_EUR = 1.13;

    /**
    * static method to convert an amount from source to target currency
    *
    *
    * @param amount
    * - amount to be converted
    * @param source
    * - source unit (currency)
    * @param target
    * - target unit
    * @return - converted value
    */
    public static double convert(double amount, Currency source, 
            Currency target) {
            /**
             * 
             * performing conversions based on source and target currencies
             */
            if (source == Currency.USD && target == Currency.EUR) {
            return amount / EUR_to_USD;
            }

            if (source == Currency.USD && target == Currency.GBP) {
            return amount / GBP_to_USD;
            }

            if (source == Currency.EUR && target == Currency.USD) {
            return amount * EUR_to_USD;
            }

            if (source == Currency.EUR && target == Currency.GBP) {
            return amount / GBP_to_EUR;
            }

            if (source == Currency.GBP && target == Currency.USD) {
            return amount * GBP_to_USD;
            }

            if (source == Currency.GBP && target == Currency.EUR) {
            return amount * GBP_to_EUR;
            }
                
            /**
             * 
             * same source & target
             */
            return amount;
    }
}

        /**
        * 
        * an enum to represent available Currency units
        */
        enum Currency {
                USD, EUR, GBP
        }

//end of Converter.java
