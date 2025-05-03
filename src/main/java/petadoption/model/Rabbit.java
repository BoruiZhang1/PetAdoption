package petadoption.model;

public class Rabbit extends Pet{

	/**
     * Constructs a new Rabbit object with the specified id, name, species, and age.
     * 
     * @param id the unique id for the rabbit
     * @param name the name of the rabbit
     * @param species the species of the rabbit
     * @param age the age of the rabbit
     */
	public Rabbit(int id, String name, String species, int age) {
		super(id, name, "Rabbit", species, age);
	}

}
