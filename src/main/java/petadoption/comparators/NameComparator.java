package petadoption.comparators;

import java.util.Comparator;

import petadoption.model.Pet;

public class NameComparator implements Comparator<Pet>{

	@Override
	public int compare(Pet p1, Pet p2) {
		return p1.getName().compareToIgnoreCase(p2.getName());
	}

}
