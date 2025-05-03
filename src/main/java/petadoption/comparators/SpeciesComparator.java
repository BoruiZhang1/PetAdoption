package petadoption.comparators;

import java.util.Comparator;

import petadoption.model.Pet;

public class SpeciesComparator implements Comparator<Pet>{

	/**
     * Compares two Pet objects based on their species.
     * 
     * @param p1 the first Pet object to be compared
     * @param p2 the second Pet object to be compared
     * @return a negative integer, zero, or a positive integer if the species is 
     *         less than, equal to, or greater than the species of 
     *         the second Pet
     */
	@Override
	public int compare(Pet p1, Pet p2) {
		return p1.getSpecies().compareToIgnoreCase(p2.getSpecies());
	}

}
