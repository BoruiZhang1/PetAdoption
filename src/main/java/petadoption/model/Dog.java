package petadoption.model;

public class Dog extends Pet{

	/**
     * Constructs a new Dog object with the specified id, name, species, and age.
     * 
     * @param id the unique id for the dog
     * @param name the name of the dog
     * @param species the species of the dog
     * @param age the age of the dog
     */
	public Dog(int id, String name, String species, int age) {
		super(id, name, "Dog", species, age);
	}
	
}
