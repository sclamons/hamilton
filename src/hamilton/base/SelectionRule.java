package hamilton.base;

/*
 * Created with IntelliJ IDEA.
 * User: Sam Clamons
 * Date: 5/19/13
 * Time: 8:28 PM
 */

/**
 * Base class for selection algorithms. Selects some individuals from a Population and removes the rest. Use for any
 * experiment where part of the population dies before breeding.
 */
public interface SelectionRule
{
    /**
     * Modifies a Population in place by removing zero or more individuals by some selection rule.
     * @param oldPopulation the Population to modify.
     */
    public void select(Population oldPopulation);
}//end interface SelectionRule
