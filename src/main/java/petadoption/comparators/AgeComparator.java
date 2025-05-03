package petadoption.comparators;

import java.util.Comparator;

import petadoption.model.Pet;

public class AgeComparator implements Comparator<Pet>{

	/**
     * Compares two Pet objects based on their age.
     * 
     * @param p1 the first Pet object to be compared
     * @param p2 the second Pet object to be compared
     * @return a negative integer, zero, or a positive integer if the age of 
     *         less than, equal to, or greater than the age of 
     *         the second Pet
     */
	@Override
	public int compare(Pet p1, Pet p2) {
		return Integer.compare(p1.getAge(), p2.getAge());
	}
	
}
