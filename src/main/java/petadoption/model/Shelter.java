package petadoption.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter<T extends Pet> {

private List<T> pets;
    
	/**
	 * Constructs and empty shelter with no pets.
	 */
    public Shelter() {
        this.pets = new ArrayList<>();
    }
    
    /**
     * Constructs a shelter with a predefined list of pets.
     * 
     * @param pets the list of pets to initialize the shelter with
     */
    public Shelter(List<T> pets) {
        this.pets = new ArrayList<>(pets);
    }

    /**
     * Adds a pet to the shelter.
     * 
     * @param pet the pet to add to the shelter
     */
    public void addPet(T pet) {
        pets.add(pet);
    }
    
    /**
     * Removes a pet from the shelter.
     * 
     * @param pet the pet to remove from the shelter
     * @return true if the pet was successfully removed, 
     *         false if the pet was not found in the shelter
     */
    public boolean removePet(T pet) {
        return pets.remove(pet);
    }
    
    /**
     * Gets the list of all pets currently in the shelter.
     * 
     * @return the list of all pets in the shelter
     */
    public List<T> getAllPets() { 
    	return pets; 
    }
    
    /**
     * Sorts the pets in the shelter according to the specified comparator.
     * 
     * @param comparator the comparator used to determine the order of the pets
     */
    public void sortBy(Comparator<T> comparator) { 
    	pets.sort(comparator); 
    }
    
    /**
     * Adopts a pet from the shelter and marks it as adopted.
     * 
     * @param pet the pet to adopt
     * @return true if the pet was successfully adopted, 
     *         false if the pet has already been adopted
     */
    public boolean adoptPet(T pet) { 
    	return pet.adopt(); 
    }
    
}
