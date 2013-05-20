package hamilton.simple;

import hamilton.base.Individual;

/*
 * Created with IntelliJ IDEA.
 * User: Sam Clamons
 * Date: 5/19/13
 * Time: 8:40 PM
 */

/**
 * An Individual with a numeric (positive) fitness attribute, which determines its relative likelihood of surviving,
 * breeding, or some other action.
 */
public class FitnessIndividual extends Individual
{
    /**
     * Constructs a new FitnessIndividual with a given fitness.
     * @param fitness the fitness of the individual
     */
    public FitnessIndividual(double fitness)
    {
        super();
        this.setFitness(fitness);
    }//end FitnessIndividual(int fitness)

    /**
     * Accessor method for getting the (numeric) value of the individual's fitness.
     * @return the fitness of this individual
     */
    public double getFitness()
    {
        return Double.valueOf(this.getAttribute("fitness"));
    }//end double getFitness

    /**
     * Setter method to set this Individual's fitness to some double. The fitness must be positive.
     * @param fitness the new fitness of the Individual
     * @throws IllegalArgumentException if fitness < 0
     */
    public void setFitness(double fitness) throws IllegalArgumentException
    {
        if(fitness < 0)
        {
            String id = String.valueOf(getID());
            throw new IllegalArgumentException("Error setting the fitness of FitScoreIndividual " + id + " Fitness cannot be less than 0.");
        }//end if
        setAttribute("fitness", String.valueOf(fitness));
    }//end void setFitness(double fitness)
}//end class FitnessIndividual extends Individual
