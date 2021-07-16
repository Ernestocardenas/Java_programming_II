import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * Polynomial class represents a polynomial.
 */
public class Polynomial {
    LinkedList<Term> terms;

    /**
     * 
     * Constructs an empty polynomial.
     */
    public Polynomial() {
        terms = new LinkedList<Term>();
    }

    /**
     * 
     * Constructs a new polynomial with the given term.
     * @param t the term to initialize the polynomial with
     */
    public Polynomial(Term t) {
        terms = new LinkedList<Term>();
        terms.add(t);
    }

    /**
     * 
     * Adds the polynomial such that the terms are in sorted order
     * from highest power to lowest.
     * @param p the polynomial to add
     */
    public void add(Polynomial p) {
        int idx = 0;
        boolean added;

        Term currTerm;

        /**
         * 
         * Compare each newTerm to current term
         */
        for(Term newTerm : p.terms) {
            added = false;
            /**
             * 
             * As long as the newTerm is not added or we have more terms to
             * compare.
             */
            while(!added && idx < terms.size()) {
                currTerm = terms.get(idx);
                /**
                 * 
                 * If the terms being compared are same power.
                 */
                if(currTerm.getPower() == newTerm.getPower()) {
                    currTerm.addIfSamePower(newTerm);
                    added = true;
                }
                
                /**
                 * 
                 * If new terms power is more than the current term.
                 */
                else if(newTerm.getPower() > currTerm.getPower()) {
                    terms.add(idx, new Term(newTerm.getCoefficient(),
                            newTerm.getPower()));
                    added = true;
                }

                /**
                 * 
                 * Otherwise move on to next term in the existing list since
                 * the power of newTerm is lesser than currTerm.
                 */
                idx++;
            }
            
                /**
                 * 
                 * If the newTerm did not match any powers in existing or its 
                 * power is not in the range of the existing.
                 */
                if(!added)
                    terms.add(new Term(newTerm.getCoefficient(),
                            newTerm.getPower())); //add to end
        }
    }

    /**
     * 
     * Multiplies the given polynomial with this one and returns the result.
     * @param p the polynomial to multiply
     * @return this p
     */
    public Polynomial multiply(Polynomial p) {
        Polynomial ans = new Polynomial();
   
        for(Term t1 : p.terms) {
            for(Term t2 : terms) {
                Term t3 = t1.multiply(t2);
                ans.add(new Polynomial(t3));
            }
        }

        return ans;
   }

    /**
     * 
     * Prints the polynomial "nicely" so that it reads
     * from highest term to lowest and doesn't have a
     * leading "+" if the first term is positive.
     */
    public void print() {
        String str = "";

        for(int i = 0; i < terms.size(); i++) {
            Term t = terms.get(i);
   
            if(t.getCoefficient() > 0) {
                if(i != 0)
                str += " + " ;
            }

            else {
                str += " - ";
            }

            str += t.toString();
        }
        
        System.out.print(str);
    }
}
