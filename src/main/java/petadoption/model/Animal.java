package petadoption.model;

public class Animal extends Pet{

	/**
	 * Constructs a new Animal object with the specified id, name, type, species, and age.
	 * 
	 * @param id the unique id for the animal
	 * @param name the name of the animal
	 * @param type the type of the animal
	 * @param species the species of the animal
	 * @param age the age of the animal
	 */
	public Animal(int id, String name, String type, String species, int age) {
		super(id, name, type, species, age);
	}
	
}
