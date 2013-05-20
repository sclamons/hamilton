import hamilton.base.Population;
import hamilton.simple.FitnessBreeding;
import hamilton.simple.FitnessIndividual;

/**
 * Created with IntelliJ IDEA.
 * User: Sam Clamons
 * Date: 5/19/13
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class FitnessExperiment
{
    final static int POP_SIZE = 10000, ITERATIONS = 100;
    final static double HIGH_FITNESS = 101, LOW_FITNESS = 100, LOW_FRACTION = 0.9;

    static FitnessBreeding breedMethod = new FitnessBreeding();
    public static void main(String[] args)
    {
        Population<FitnessIndividual> critters = new Population<FitnessIndividual>();
        for(int x = 0; x < POP_SIZE * LOW_FRACTION; x++)
        {
            critters.addIndividual(new FitnessIndividual(LOW_FITNESS));
        }//end for x
        for(int x = 0; x < POP_SIZE * (1 - LOW_FRACTION); x++)
        {
            critters.addIndividual(new FitnessIndividual(HIGH_FITNESS));
        }//end for x

        for(int x = 0; x < ITERATIONS; x++)
        {
            critters = breedMethod.breed(critters);
            System.out.println("Generation " + x);
            if(printPopulation(critters) == POP_SIZE)
            {
                break;
            }//end if
        }//end for x
    }//end main(String[] args)

    private static int printPopulation(Population<FitnessIndividual> population)
    {
        int low_fitness_count = 0;
        int high_fitness_count = 0;
        int aberrant_count = 0;

        for(FitnessIndividual critter: population)
        {
            if(critter.getFitness() == LOW_FITNESS)
            {
                low_fitness_count++;
            }//end if
            else if(critter.getFitness() == HIGH_FITNESS)
            {
                high_fitness_count++;
            }
            else
            {
                aberrant_count++;
            }//end else
        }//end for critter
        System.out.println("Population statistics:");
        System.out.println("\t# High Fitness: " + high_fitness_count);
        System.out.println("\t# Low Fitness: " + low_fitness_count);
        System.out.println("\t# Aberrant Fitness: " + aberrant_count);
        System.out.println("\tTotal Population: " + population.size());
        System.out.println("");

        return high_fitness_count;
    }//end private void printPopulation(Population<FitnessIndividual> population)
}//end class FitnessExperiment
