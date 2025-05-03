package petadoption.model;

import java.util.ArrayList;
import java.util.List;

public class Shelter<T extends Pet> {

private List<T> pets;
    
    public Shelter() {
        this.pets = new ArrayList<>();
    }
    
    public Shelter(List<T> pets) {
        this.pets = new ArrayList<>(pets);
    }

    void addPet(T pet) {
        pets.add(pet);
    }
    
    public boolean removePet(T pet) {
        return pets.remove(pet);
    }
    
}
