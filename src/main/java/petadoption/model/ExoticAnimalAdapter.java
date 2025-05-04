package petadoption.model;




//funnily enough when we started with the 
public class ExoticAnimalAdapter extends Pet {

	private ExoticAnimal exoticAnimal;
	
	
	/** ExoticAnimalAdapter wraps exotic animal
	 * @param exoticAnimal is to be adapted to pet
	 */
	public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
		
		super(Integer.parseInt(exoticAnimal.getUniqueId().substring(3)), 
			  exoticAnimal.getAnimalName(),
			  exoticAnimal.getCategory(),
			  exoticAnimal.getSubSpecies(),
			  exoticAnimal.getYearsOld());
		this.exoticAnimal = exoticAnimal;
		//if isAvailible is true we must reverse it to false so that setAdoption status is not adopted and vice versa
		this.setAdopted(!exoticAnimal.isAvailable());
		
	}

	
	/** 
	 * @return status true if pet gets adopted and false if pet is already adopted
	 */
	@Override
    public boolean adopt() {
        boolean status = super.adopt();
        if (status) {
            exoticAnimal.markAsAdopted();
        }
        return status;
    }
	
	/*
	 * using the function to server as a connection between the pet class's and 
	 * adoption status in the exoticAnimal class's
	 */
	public void setAdopted(boolean adopted)
	{
		super.setAdopted(adopted);
		exoticAnimal.setAvailable(!adopted);
	}
	
	
	public ExoticAnimal getExoticAnimal() {
		return exoticAnimal;
	}


	
	
	
	
}
