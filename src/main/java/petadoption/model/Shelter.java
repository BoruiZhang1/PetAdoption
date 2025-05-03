package petadoption.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter<T extends Pet> {

private List<T> pets;
    
    public Shelter() {
        this.pets = new ArrayList<>();
    }
    
    public Shelter(List<T> pets) {
        this.pets = new ArrayList<>(pets);
    }

    public void addPet(T pet) {
        pets.add(pet);
    }
    
    public boolean removePet(T pet) {
        return pets.remove(pet);
    }
    
    public List<T> getAllPets() { 
    	return pets; 
    }
    
    public void sortBy(Comparator<T> comparator) { 
    	pets.sort(comparator); 
    }
    
    public boolean adoptPet(T pet) { 
    	return pet.adopt(); 
    }
    
}
