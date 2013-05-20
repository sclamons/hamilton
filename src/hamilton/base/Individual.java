package hamilton.base;

import java.util.HashMap;

import static java.lang.Integer.valueOf;

/*
 * Created with IntelliJ IDEA.
 * User: Sam Clamons
 * Date: 5/19/13
 * Time: 3:08 PM
 */

/**
 * Superclass for Individuals in a population.
 *
 * Every Individual class represents a different species or type of individual in a population. Different species may
 * have different attributes or qualities. To represent these qualities, Individuals may have any number of attributes,
 * which are string values keyed by string labels. For example, an individual of class Lizard might have the attribute
 * label "color", which might be keyed to "green", "red", or "speckled". Attributes should be encapsulated so that
 * they can only be created or deleted by the Individual's own methods, and preferably only created in
 * Individual's constructor.
 *
 * Every Individual is required to maintain an ID attribute, which should be unique within a population.
 */
public abstract class Individual
{
    protected HashMap<String, String> attributes;

    /**
     * Default constructor for all Individuals
     */
    public Individual()
    {
        attributes = new HashMap<String, String>();
        attributes.put("id", "-1");
    }//end Individual()

    /**
     * Returs a single-line descriptor of the Individual by listing the Individual's attributes and values for those
     * attributes.
     *
     * @return a String descriptor of the Individual
     */
    public String toString()
    {
        String returnString = "";
        boolean firstLine = true;
        for(String label: attributes.keySet())
        {
            if(firstLine)
            {
                firstLine = false;
            }//end if
            else
            {
                returnString += ";  ";
            }//end else
            returnString += label + " : " + attributes.get(label);
        }//end for label

        return returnString;
    }//end String toString()

    /**
     * Basic accessor method for attributes.
     *
     * @param label the label of the attribute whose value is returned.
     * @return the value of the argument specified by 'label'.
     * @throws IllegalArgumentException if the specified attribute does not exist
     */
    public String getAttribute(String label) throws IllegalArgumentException
    {
        if(!(attributes.keySet().contains(label)))
        {
            throw new IllegalArgumentException("This individual does not have an attribute \"" + label + "\".");
        }//end if
        return attributes.get(label);
    }//end String getAttribute(String label)

    /**
     * Basic setter method for attributes.
     * @param label the label of the attribute to be set. The attribute being set should already exist.
     * @param newValue new value of the attribute named by label.
     */
    public void setAttribute(String label, String newValue)
    {
        attributes.put(label, newValue);
    }//end void setAttribute(String label, String newValue) throws IllegalArgumentException

    /**
     * Setter method for the Individual's ID.
      * @param id integer value of the new ID.
     */
    public void setID(int id)
    {
        attributes.put("id", String.valueOf(id));
    }//end void setID(int id)

    /**
     * Accessor method for the Individual's ID.
     * @return integer value of the Individual's ID.
     */
    public int getID()
    {
        return valueOf(attributes.get("id"));
    }//end int getID()
}//end abstract class Individual
