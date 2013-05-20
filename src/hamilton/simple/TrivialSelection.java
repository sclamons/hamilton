package hamilton.simple;

import hamilton.base.Population;
import hamilton.base.SelectionRule;

/*
 * Created with IntelliJ IDEA.
 * User: Sam Clamons
 * Date: 5/19/13
 * Time: 8:59 PM
 */

/**
 * Trivial selection rule -- no Individuals are removed.
 */
public class TrivialSelection implements SelectionRule
{
    /**
     * Trivial selection rule that does not modify the population.
      * @param oldPopulation the Population to modify.
     */
    public void select(Population oldPopulation)
    {
        return;
    }
}//end class TrivialSelection implements SelectionRule