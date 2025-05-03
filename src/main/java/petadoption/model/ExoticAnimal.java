package petadoption.model;

public class ExoticAnimal {
	
	private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;
    private boolean isAvailable;
    
    /**
     * Constructs a new ExoticAnimal object with the specified uniqueId, animalName, 
     * category, subSpecies, and yearsOld. The animal is initially marked as available.
     * 
     * @param uniqueId the unique id for the exotic animal
     * @param animalName the name of the exotic animal
     * @param category the category of the animal
     * @param subSpecies the sub species of the exotic animal
     * @param yearsOld the age of the exotic animal
     */
    public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
		super();
		this.uniqueId = uniqueId;
		this.animalName = animalName;
		this.category = category;
		this.subSpecies = subSpecies;
		this.yearsOld = yearsOld;
		this.isAvailable = true;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubSpecies() {
		return subSpecies;
	}

	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	public int getYearsOld() {
		return yearsOld;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * Marks the exotic animal as adopted by changing availability status to false.
	 */
	public void markAsAdopted() {
		this.isAvailable = false;
	}

	@Override
	public String toString() {
		return "ExoticAnimal [uniqueId=" + uniqueId + ", animalName=" + animalName + ", category=" + category
				+ ", subSpecies=" + subSpecies + ", yearsOld=" + yearsOld + ", isAvailable=" + isAvailable + "]";
	}

}
