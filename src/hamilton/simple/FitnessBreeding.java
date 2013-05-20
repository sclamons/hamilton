package hamilton.simple;

/*
 * Created with IntelliJ IDEA.
 * User: Sam Clamons
 * Date: 5/19/13
 * Time: 9:12 PM
 */

import hamilton.base.BreedingRule;
import hamilton.base.Population;

import java.util.Random;

/**
 * Simple asexual breeding algorithm based on fitness scores (requires individuals with a fitness score). The likelihood
 * of an individual producing offspring is proportional to the ratio between its own fitness and the total fitness
 * of its entire generation. This algorithm produces generations with size equal to that of the parent generation.
 */
public class FitnessBreeding implements BreedingRule
{
    Random r = new Random();

    /**
     * Construct a FitnessBreeding object with a nondeterministic(?) seed value for random selection of individuals.
     */
    public FitnessBreeding()
    {
        super();
    }//end FitnessBreeding()

    /**
     * Construct a FitnessBreeding object with a seed for random selection.
     * @param seed the seed to set for random selection of individuals
     */
    public FitnessBreeding(long seed)
    {
        r.setSeed(seed);
    }//end FitnessBreeding(long seed)

    /**
     * Generate a new Population, the same size as the parent generation, populated with clones of the parent
     * Population. To select Individuals to clone, pick Individuals randomly, weighted by their fitness.
     * @param oldPopulation the parent generation
     * @return a new generation of Individuals cloned stochastically from the parent.
     */
    public Population breed(Population oldPopulation)
    {
        Population<FitnessIndividual> parents = (Population<FitnessIndividual>)oldPopulation;
        int totalFitness = countTotalFitness(parents);

        Population<FitnessIndividual> newPopulation = new Population<FitnessIndividual>();
        for(int x = 0; x < parents.size(); x++)
        {
            newPopulation.addIndividual(selectIndividual(parents, totalFitness));
        }//end for x
        return newPopulation;
    }//end Population breed(Population oldPopulation)

    private int countTotalFitness(Population<FitnessIndividual> oldPopulation)
    {
        int count = 0;
        for(FitnessIndividual critter: oldPopulation)
        {
            count += critter.getFitness();
        }//end for critter
        return count;
    }//end private int countTotalFitness(Population oldPopulation)

    private FitnessIndividual selectIndividual(Population<FitnessIndividual> parents, int totalFitness)
    {
        double selection = r.nextDouble() * totalFitness;
        FitnessIndividual lastCritter = null;
        for(FitnessIndividual critter: parents)
        {
            lastCritter = critter;
            selection -= critter.getFitness();
            if(selection <= 0)
            {
                return critter;
            }//end if
        }//end for critter
        return lastCritter;
    }//end private FitnessIndividual selectIndividual(Population<FitnessIndividual> parents)
}//end class FitnessBreeding implements BreedingRule
