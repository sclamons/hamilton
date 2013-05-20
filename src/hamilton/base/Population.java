package hamilton.base;

/*
 * Created with IntelliJ IDEA.
 * User: Sam Clamons
 * Date: 5/19/13
 * Time: 3:39 PM
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Wrapper class for populations of individuals.
 *
 * One Population stores zero or more Individuals. Individuals can be accessed sequentially (using an iterator),
 * randomly, or by ID.
 */
public class Population<T extends Individual> implements Iterable<T>
{
    private Random r;
    private LinkedList<T> individuals;
    int nextID;

    /**
     * Default constructor. Creates an empty population.
     */
    public Population()
    {
        r = new Random();
        individuals = new LinkedList<T>();
        nextID = 0;
    }//end Population()

    /**
     * Returns the size of the population.
     * @return the number of the Individuals in the population.
     */
    public int size()
    {
        return individuals.size();
    }//end int size()

    public String toString()
    {
        String returnString = "Members:";
        for(T critter: individuals)
        {
            returnString += "\n\t" + critter;
        }//end for critter

        return returnString;
    }//end String toString()

    /**
     * Returns an Iterator a la the Iterable interface (specifically, a ListIterator). The Iterator returned will
     * iterate from the Individual with the smallest ID to the Individual with the largest ID.
     * @return an iterator which sequentially returns Individuals from the Population.
     */
    public Iterator<T> iterator()
    {
        return individuals.iterator();
    }//end Iterator<Individual> iterator()

    /**
     * Adds a new Individual, with a new ID number, to the population. The new Individual will be assigned an ID one
     * higher than the previously-highest ID in the Population.
     * @param newMember the individual added.
     * @return the ID number of the new individual.
     */
    public int addIndividual(T newMember)
    {
        newMember.setID(nextID);
        nextID++;
        individuals.addLast(newMember);
        return nextID - 1;
    }//end int addIndividual(Individual newMember)

    /**
     * Accessor method that gets an Individual with a specified ID.
     * @param id ID of the Individual returned.
     * @return Individual in the Population with the specified ID (or null if there is no such individual).
     */
    public Individual getIndividual(int id)
    {
        for(Individual next: individuals)
        {
            if(next.getID() == id)
            {
                return next;
            }//end if
        }//end for next
        return null;
    }//end Individual getIndividual(int id)

    /**
     * Accessor method that gets a random individual.
     * @return a random individual from the Population.
     */
    public Individual getRandomIndividual()
    {
        int index = r.nextInt(individuals.size());
        return individuals.get(index);
    }//end Individual getRandomIndividual()

    /**
     * Accessor method that gets a random individual from the Population while setting the seed used internally to
     * select Individuals.
     * @param seed new random seed, set before returning a new Individual
     * @return a random Individual from the Population, using the new seed value.
     */
    public Individual getRandomIndividual(long seed)
    {
        r.setSeed(seed);
        return this.getRandomIndividual();
    }//end Individual getRandomIndividual(int seed)
}//end class Population
