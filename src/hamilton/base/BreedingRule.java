package hamilton.base;

/*
 * Created with IntelliJ IDEA.
 * User: Sam Clamons
 * Date: 5/19/13
 * Time: 8:12 PM
 */

/**
 * Base class for breeding algorithms. Every BreedingRule contains a rule for taking a population and producing
 * a new generation of population from it.
 */
public interface BreedingRule
{
    /**
     * Generates a new generation of Individuals based on the previous generation
     * @param oldGeneration the current generation of Individuals (a Population).
     * @return a new generation (Population) of Individuals, generated from oldGeneration.
     */
    public Population breed(Population oldGeneration);
}//end interface BreedingRule
