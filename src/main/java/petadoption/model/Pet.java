package petadoption.model;

public abstract class Pet implements Comparable<Pet>{
	
	private int id;
	private String name;
	private String type;
	private String species;
	private int age;
	private boolean adopted;
	
	/**
     * Constructs a new Pet object with the specified id, name, type, species, and age.
     * The pet is initially not adopted.
     * 
     * @param id the unique id for the pet
     * @param name the name of the pet
     * @param type the type of the pet
     * @param species the species of the pet
     * @param age the age of the pet
     */
	public Pet(int id, String name, String type, String species, int age) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
	/**
	 * Adopts a pet by changing its adoption status.
	 * 
	 * @return true if the pet was adopted or false if the pet is already adopted
	 */
	public boolean adopt() {
		if(!adopted) {
			adopted = true;
			return true;
		}
		return false;
	}
	
	/**
     * Compares this pet to another pet based on their name.
     * 
     * @param other the pet to compare to
     * @return a negative integer, zero, or a positive integer if this pets name 
     *         is less than, equal to, or greater than the other pets name
     */
	@Override
    public int compareTo(Pet other) {
        return this.name.compareToIgnoreCase(other.getName());
    }

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", age=" + age
				+ ", adopted=" + adopted + "]";
	}

}
