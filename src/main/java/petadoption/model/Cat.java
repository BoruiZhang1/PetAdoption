package petadoption.model;

public class Cat extends Pet{

	/**
     * Constructs a new Cat object with the specified id, name, species, and age.
     * 
     * @param id the unique id for the cat
     * @param name the name of the cat
     * @param species the species of the cat
     * @param age the age of the cat
     */
	public Cat(int id, String name, String species, int age) {
		super(id, name, "Cat", species, age);
	}

}
