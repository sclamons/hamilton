package hamilton.simple;

/*
 * Created with IntelliJ IDEA.
 * User: Sam Clamons
 * Date: 5/19/13
 * Time: 8:57 PM
 */

import hamilton.base.BreedingRule;
import hamilton.base.Population;

/**
 * Trivial breeding rule where a population is simply copied from one generation to the next.
 */
public class TrivialBreeding implements BreedingRule
{
    /**
     * The old population is trivially returned.
     * @param oldPopulation the population to be bred.
     * @return oldPopulation
     */
    public Population breed(Population oldPopulation)
    {
        return oldPopulation;
    }//end Population breed(Population oldPopulation)
}//end class TrivialBreeding implements BreedingRule
